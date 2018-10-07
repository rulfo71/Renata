package ar.edu.uca;

import ar.edu.uca.entities.Agente;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class RepositoriesConf extends RepositoryRestConfigurerAdapter {

	  @Override
	  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Agente.class);
    }

}
