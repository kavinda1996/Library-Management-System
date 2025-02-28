package service;

import service.custom.impl.UsersBoImpl;
import service.custom.impl.BooksBoImpl;
import util.BoType;

public class BoFactory {
    private static BoFactory instance;
    private BoFactory(){}
    public static BoFactory getInstance() {
        return instance==null?instance=new BoFactory():instance;
    }
    public <T extends SuperService> T getBoType(BoType type){

        switch (type){
            case CUSTOMER: return (T) new UsersBoImpl();
            case ITEM:return (T) new BooksBoImpl();
        }
        return null;

    }
}
