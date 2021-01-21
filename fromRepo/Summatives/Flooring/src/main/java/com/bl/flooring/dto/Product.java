/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.flooring.dto;

import java.math.BigDecimal;

/**
 *
 * @author benth
 */
public class Product {
    private String productName;
    private BigDecimal materialCostBySqFoot;
    private BigDecimal laborCostBySqFoot;

    public Product(String productName, BigDecimal materialCostBySqFoot, BigDecimal laborCostBySqFoot) {
        this.productName = productName;
        this.materialCostBySqFoot = materialCostBySqFoot;
        this.laborCostBySqFoot = laborCostBySqFoot;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getMaterialCostBySqFoot() {
        return materialCostBySqFoot;
    }

    public void setMaterialCostBySqFoot(BigDecimal materialCostBySqFoot) {
        this.materialCostBySqFoot = materialCostBySqFoot;
    }

    public BigDecimal getLaborCostBySqFoot() {
        return laborCostBySqFoot;
    }

    public void setLaborCostBySqFoot(BigDecimal laborCostBySqFoot) {
        this.laborCostBySqFoot = laborCostBySqFoot;
    }
    
    
}
