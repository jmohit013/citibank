package com.city.CityMockitoDemo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;

public class BusinessAppMockitoTest {

	@Test(expected = NullPointerException.class)
	public void testRetrieveCities() {
		CityService cityService = mock(CityService.class);
		//when(cityService.findCitiesByCountries("USA")).thenReturn(Arrays.asList("New York", "Washington"));
		//when(cityService.findCitiesByCountries("INDIA")).thenReturn(Arrays.asList("Delhi", "Mumbai", "Kolkatta", "Chennai"));
		
		//Matcher
		//when(cityService.findCitiesByCountries(anyString())).thenReturn(Arrays.asList("city1", "city2", "city3"));
		
		when(cityService.findCitiesByCountries("SWEDEN")).thenThrow(NullPointerException.class);
		
		BusinessApp businessApp = new BusinessApp(cityService);
		assertEquals(3, businessApp.retrieveCityListByCountry("SWEDEN").size());
		
	}

}
