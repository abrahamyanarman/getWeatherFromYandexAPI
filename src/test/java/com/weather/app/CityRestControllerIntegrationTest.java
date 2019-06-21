package com.weather.app;

import com.weather.app.controller.CityController;
import com.weather.app.dao.City;
import com.weather.app.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

;

/**
 * @author Arman Abrahamyan on 6/17/2019.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
public class CityRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Qualifier("cityServiceImpl")
    private CityService cityService;

    @Test
    public void gettingCity_WhenGetCity_ThenRetuneJsonArray() throws Exception {
        City city = new City();
        city.setArea("city");
        city.setCity("city");
        city.setLatitude(11.55);
        city.setLongitude(22.22);

        List<City> cities = Arrays.asList(city);

        given(cityService.findCityByArea("city")).willReturn(cities);

        mockMvc.perform(get("/area?area=city")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(1))).andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andExpect(MockMvcResultMatchers.jsonPath("$[0]",cities).hasJsonPath());



    }

}
