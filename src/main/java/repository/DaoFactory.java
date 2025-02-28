package repository;

import repository.custom.impl.UsersDaoImpl;
import repository.custom.impl.BooksDaoImpl;
import util.DaoType;

public class DaoFactory {
    private static DaoFactory instance;
    private DaoFactory(){}
    public static DaoFactory getInstance() {
        return instance==null?instance=new DaoFactory():instance;
    }

    public <T extends SuperDao> T getDaoType(DaoType type){
                switch (type){
                    case users: return (T) new UsersDaoImpl();
                    case ITEM:return (T) new BooksDaoImpl();
                }
    return null;
    }

}
