package za.co.wethinkcode.database.job;

import java.sql.SQLException;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.collect.ImmutableList;

import net.lemnik.eodsql.QueryTool;
import za.co.wethinkcode.database.model.Register;
import za.co.wethinkcode.database.orm.Query;
import za.co.wethinkcode.database.service.Connector;

/**
 * 
 */
public class Repo implements Memory{

    private Connector con = new Connector();
    private final Query query = QueryTool.getQuery(con.connection(), Query.class );

    public void testData(){}

    /**
     * {@inheritDoc}
     * @throws SQLException
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    @Override
    public void newRegister(Register register){

        query.addNewUser(register.getId(), register.getName(), register.getSurname(), register.getEmail(), register.getPassword(), register.getDate());
    }

    @Override
    public void removeRegister(Register user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateUpdate(Register user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Register findRegisteredByEmail(String email) {
        Register registered = query.findbyUserEmail(email);
        return registered;
    }

    @Override
    public ImmutableList<Register> findRegisters() {
        // TODO Auto-generated method stub
        return null;
    }
}
