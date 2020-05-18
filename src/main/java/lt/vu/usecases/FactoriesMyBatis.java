package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.model.Factory;
import lt.vu.mybatis.dao.FactoryMapper;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@javax.enterprise.inject.Model
public class FactoriesMyBatis {

    @Inject
    private FactoryMapper factoryMapper;

    @Getter @Setter
    private Factory factoryToCreate = new Factory();

    @Getter
    private List<Factory> allFactories;

    @PostConstruct
    public void init(){ loadAllFactories(); }

    @Transactional
    private void loadAllFactories() { allFactories = factoryMapper.selectAll(); }

    @Transactional
    public String createFactory(){
        factoryMapper.insert(factoryToCreate);
        return "/mybatis/factories?faces-redirect=true";
    }
}