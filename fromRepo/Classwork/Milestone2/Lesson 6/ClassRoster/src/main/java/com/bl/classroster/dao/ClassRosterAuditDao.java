/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.classroster.dao;

/**
 *
 * @author benth
 */
public interface ClassRosterAuditDao {
   
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException;
   
}
