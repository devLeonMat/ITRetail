package com.rleon.clientes.service;

import com.rleon.clientes.dao.ClientDao;
import com.rleon.clientes.model.Client;
import com.rleon.clientes.model.Kpi;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.rleon.clientes.utils.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ClientDao userDao;

    @Override
    public Client createNewCliente(Client user) throws Exception {
        Client newClient = new Client();
        try {

            newClient.setNombres(user.getNombres());
            newClient.setApellidoPaterno(user.getApellidoPaterno());
            newClient.setApellidoMaterno(user.getApellidoMaterno());
            newClient.setEdad(user.getEdad());
            newClient.setFechaDeNacimiento(user.getFechaDeNacimiento());
            newClient.setFechaPosFallecimiento(calcularEsperanzaVida(newClient));

            /** esperanza de vida (podriamos hacerlo configurable, pero desconozco como calculan en su compania la esperanza de vida, pero esto puede agregarse a esta logica)
             pondremos como esperanza de vida en peru 80 años
             **/


            return userDao.save(newClient);

        } catch (Exception e) {
            logger.error("Error-->{}", e.getMessage());
            throw new Exception(e);
        }
    }

    @Override
    public List<Client> findAll() {
        return userDao.findAll();
    }

    @Override
    public Kpi getKpi() throws Exception {
        Kpi kpi = new Kpi();
        try {
            List<Client> listClient = userDao.findAll();
            /** cantidad de registros **/
            int cantRegist = listClient.size();

            /** Suma de edades **/
            int sumaEdades = listClient.stream().mapToInt(m -> m.getEdad()).sum();

            /** Media o Promedio de edades **/
            double mediaAritmetica = sumaEdades / cantRegist;

            double sumatoria = 0;

            for (Client client : listClient) {
                sumatoria += Math.pow(client.getEdad() - mediaAritmetica, 2);
            }

            double desvSt = Math.sqrt(sumatoria / (cantRegist - 1));
            kpi.setPromEdad(mediaAritmetica);
            kpi.setDesvStandar(Validate.redondearDecimales(desvSt, 2));

        } catch (Exception e) {
            logger.error("Error->{}", e.getMessage());
            throw new Exception(e);
        }
        return kpi;
    }

    @Deprecated
    private Date calcularEsperanzaVida(Client cliente){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cliente.getFechaDeNacimiento());
        calendar.add(Calendar.YEAR, 80);
        return calendar.getTime();
    }

}
