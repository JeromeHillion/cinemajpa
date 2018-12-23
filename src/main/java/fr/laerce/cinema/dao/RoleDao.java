/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.laerce.cinema.dao;

import fr.laerce.cinema.model.PlayPk;
import fr.laerce.cinema.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gideon
 */

@Component

public interface RoleDao extends CrudRepository<Role, PlayPk> {


}
