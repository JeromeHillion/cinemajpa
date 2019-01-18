/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.laerce.cinema.dao;

import fr.laerce.cinema.model.Play;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author Gideon
 */

@Component

public interface RoleDao extends CrudRepository<Play, Long> {
    public List<Play> findAllByOrderByIdAsc();

}
