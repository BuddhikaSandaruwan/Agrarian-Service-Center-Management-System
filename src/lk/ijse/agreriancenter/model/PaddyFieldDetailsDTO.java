/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.model;

/**
 *
 * @author Buddhika
 */
public class PaddyFieldDetailsDTO {
    private PaddyFieldDTO paddyFieldDTO;
    private OwnerDTO ownerDTO;
    private FarmerDTO farmerDTO;

    public PaddyFieldDetailsDTO() {
    }

    public PaddyFieldDetailsDTO(PaddyFieldDTO paddyFieldDTO, OwnerDTO ownerDTO, FarmerDTO farmerDTO) {
        this.paddyFieldDTO = paddyFieldDTO;
        this.ownerDTO = ownerDTO;
        this.farmerDTO = farmerDTO;
    }

    /**
     * @return the paddyFieldDTO
     */
    public PaddyFieldDTO getPaddyFieldDTO() {
        return paddyFieldDTO;
    }

    /**
     * @param paddyFieldDTO the paddyFieldDTO to set
     */
    public void setPaddyFieldDTO(PaddyFieldDTO paddyFieldDTO) {
        this.paddyFieldDTO = paddyFieldDTO;
    }

    /**
     * @return the ownerDTO
     */
    public OwnerDTO getOwnerDTO() {
        return ownerDTO;
    }

    /**
     * @param ownerDTO the ownerDTO to set
     */
    public void setOwnerDTO(OwnerDTO ownerDTO) {
        this.ownerDTO = ownerDTO;
    }

    /**
     * @return the farmerDTO
     */
    public FarmerDTO getFarmerDTO() {
        return farmerDTO;
    }

    /**
     * @param farmerDTO the farmerDTO to set
     */
    public void setFarmerDTO(FarmerDTO farmerDTO) {
        this.farmerDTO = farmerDTO;
    }

    @Override
    public String toString() {
        return "PaddyFieldDetailsDTO{" + "paddyFieldDTO=" + paddyFieldDTO + ", ownerDTO=" + ownerDTO + ", farmerDTO=" + farmerDTO + '}';
    }
    
    
    
}
