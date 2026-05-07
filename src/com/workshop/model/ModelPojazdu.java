package com.workshop.model;

import java.util.Objects;

public class ModelPojazdu {
    private int modelId;
    private String marka;
    private String model;
    private Integer rocznikOd;
    private Integer rocznikDo;
    private String typNadwozia;

    public ModelPojazdu(int modelId, String marka, String model) {
        this.modelId = modelId;
        this.marka = marka;
        this.model = model;
    }

    public String getGrupaModel() {
        return marka + " " + model;
    }

    public boolean czyWszystkieModele() {
        return rocznikOd == null && rocznikDo == null && "*".equals(model);
    }

    // gettery i settery
    public int getModelId() {
        return modelId; 
    }
    public String getMarka() { 
        return marka; 
    }
    public String getModel() { 
        return model; 
    }
    public Integer getRocznikOd() { 
        return rocznikOd; 
    }
    public void setRocznikOd(Integer rocznikOd) { 
        this.rocznikOd = rocznikOd; 
    }
    public Integer getRocznikDo() { 
        return rocznikDo; 
    }
    public void setRocznikDo(Integer rocznikDo) { 
        this.rocznikDo = rocznikDo; 
    }
    public String getTypNadwozia() { 
        return typNadwozia; 
    }
    public void setTypNadwozia(String typNadwozia) { 
        this.typNadwozia = typNadwozia; 
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof ModelPojazdu)){
            return false;
        } 
        ModelPojazdu that = (ModelPojazdu) obj;
        return modelId == that.modelId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelId);
    }
}