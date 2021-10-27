package org.yn.app;

import org.junit.jupiter.api.Test;
import org.yn.app.domain.Hero;
import org.yn.app.service.GalaxyService;

public class GalaxyServiceTest {

    @Test
    void testMyClass(){
        GalaxyService galaxyService = new GalaxyService();
        galaxyService.addHero(new Hero());
    }
}
