package com.mlc.MLC.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "steps")
public class Steps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "step1")
    private String step1;
    @Column(name = "step2")
    private String step2;
    @Column(name = "step3")
    private String step3;
    @Column(name = "step4")
    private String step4;
    @Column(name = "step5")
    private String step5;
    @Column(name = "step6")
    private String step6;
    @Column(name = "step7")
    private String step7;
    @Column(name = "step8")
    private String step8;
    @Column(name = "step9")
    private String step9;
    @Column(name = "step10")
    private String step10;
    @JsonBackReference
    @OneToOne(mappedBy = "steps", cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private Recipe recipe;

    public Steps(String step1) {
        this.step1 = step1;
        this.step2 = "";
        this.step3 = "";
        this.step4 = "";
        this.step5 = "";
        this.step6 = "";
        this.step7 = "";
        this.step8 = "";
        this.step9 = "";
        this.step10 = "";
//        this.recipe = new Recipe();
    }
    public Steps(){}
    public String getStep1() {
        return step1;
    }

    public void setStep1(String step1) {
        this.step1 = step1;
    }

    public String getStep2() {
        return step2;
    }

    public void setStep2(String step2) {
        this.step2 = step2;
    }

    public String getStep3() {
        return step3;
    }

    public void setStep3(String step3) {
        this.step3 = step3;
    }

    public String getStep4() {
        return step4;
    }

    public void setStep4(String step4) {
        this.step4 = step4;
    }

    public String getStep5() {
        return step5;
    }

    public void setStep5(String step5) {
        this.step5 = step5;
    }

    public String getStep6() {
        return step6;
    }

    public void setStep6(String step6) {
        this.step6 = step6;
    }

    public String getStep7() {
        return step7;
    }

    public void setStep7(String step7) {
        this.step7 = step7;
    }

    public String getStep8() {
        return step8;
    }

    public void setStep8(String step8) {
        this.step8 = step8;
    }

    public String getStep9() {
        return step9;
    }

    public void setStep9(String step9) {
        this.step9 = step9;
    }

    public String getStep10() {
        return step10;
    }

    public void setStep10(String step10) {
        this.step10 = step10;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
