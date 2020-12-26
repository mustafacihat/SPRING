package com.cybertek.repository;

import com.cybertek.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    List<Region> findAllRegionsByCountry(String country);
    List<Region>findAllRegions();


    //Display all regions in Canada
    List<Region> findByCountry(String country);

    //Display all regions in Canada, without duplicates
    List<Region> findDistinctByCountry(String country);

    //Display all regions with country name includes 'United'
    List<Region> findByCountryContaining(String country);

    //Display all regions with country name includes 'United' in order
    List<Region> findByCountryContainsOrderByCountry(String country);

    //Display top 2 rigions in Canada
    List<Region> findTop2ByCountry(String country);
}
