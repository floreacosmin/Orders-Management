package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.EmailValidator;
import bll.validators.ClientAgeValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;

/**
 * Class for client operations
 *
 */
public class ClientBLL {

    private List<Validator<Client>> validators;
    private ClientDAO clientDAO;


    /**
     * Constructor without parameters
     */
    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        validators.add(new ClientAgeValidator());
        clientDAO = new ClientDAO();
    }

    /**
     * Method for searching a client by id
     * @param id search by id
     * @return Client
     */

    public Client findClientById(int id) {
        Client st = clientDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The Client with id =" + id + " was not found!");
        }
        return st;
    }

    /**
     * Method returns the list of clients from database
     * @return List<Client>
     */
    public List<Client> findAllClient() {
        return clientDAO.findAll();
    }

    /**
     * Method for validating an inserting a client
     * @param Client Client to be inserted
     * @return int
     */
    public int insertClient(Client Client) {
        for (Validator<Client> v : validators) {
            v.validate(Client);
        }
        return clientDAO.insert(Client);
    }

    /**
     * Method for validating and updating a client
     * @param client client to be updated
     * @return int
     */
    public int updateClient(Client client) {
        for (Validator<Client> v : validators) {
            v.validate(client);
        }
        return clientDAO.update(client);
    }


    /**
     * Method for deleting a client with given id
     * @param id id of client to be deleted
     * @return int
     */
    public int deleteClient(int id) {
        return clientDAO.delete(id);
    }
}
