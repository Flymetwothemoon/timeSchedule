package com.example.module_homepage.gson.get;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class DataDTO implements Serializable {
    @SerializedName("foodId")
    public String foodId;
    @SerializedName("name")
    public String name;
    @SerializedName("calory")
    public String calory;
    @SerializedName("caloryUnit")
    public String caloryUnit;
    @SerializedName("joule")
    public String joule;
    @SerializedName("jouleUnit")
    public String jouleUnit;
    @SerializedName("protein")
    public String protein;
    @SerializedName("proteinUnit")
    public String proteinUnit;
    @SerializedName("fat")
    public String fat;
    @SerializedName("fatUnit")
    public String fatUnit;
    @SerializedName("saturatedFat")
    public String saturatedFat;
    @SerializedName("saturatedFatUnit")
    public String saturatedFatUnit;
    @SerializedName("fattyAcid")
    public String fattyAcid;
    @SerializedName("fattyAcidUnit")
    public String fattyAcidUnit;
    @SerializedName("mufa")
    public String mufa;
    @SerializedName("mufaUnit")
    public String mufaUnit;
    @SerializedName("pufa")
    public String pufa;
    @SerializedName("pufaUnit")
    public String pufaUnit;
    @SerializedName("cholesterol")
    public String cholesterol;
    @SerializedName("cholesterolUnit")
    public String cholesterolUnit;
    @SerializedName("carbohydrate")
    public String carbohydrate;
    @SerializedName("carbohydrateUnit")
    public String carbohydrateUnit;
    @SerializedName("sugar")
    public String sugar;
    @SerializedName("sugarUnit")
    public String sugarUnit;
    @SerializedName("fiberDietary")
    public String fiberDietary;
    @SerializedName("fiberDietaryUnit")
    public String fiberDietaryUnit;
    @SerializedName("natrium")
    public String natrium;
    @SerializedName("natriumUnit")
    public String natriumUnit;
    @SerializedName("alcohol")
    public String alcohol;
    @SerializedName("alcoholUnit")
    public String alcoholUnit;
    @SerializedName("vitaminA")
    public String vitaminA;
    @SerializedName("vitaminAUnit")
    public String vitaminAUnit;
    @SerializedName("carotene")
    public String carotene;
    @SerializedName("caroteneUnit")
    public String caroteneUnit;
    @SerializedName("vitaminD")
    public String vitaminD;
    @SerializedName("vitaminDUnit")
    public String vitaminDUnit;
    @SerializedName("vitaminE")
    public String vitaminE;
    @SerializedName("vitaminEUnit")
    public String vitaminEUnit;
    @SerializedName("vitaminK")
    public String vitaminK;
    @SerializedName("vitaminKUnit")
    public String vitaminKUnit;
    @SerializedName("thiamine")
    public String thiamine;
    @SerializedName("thiamineUnit")
    public String thiamineUnit;
    @SerializedName("lactoflavin")
    public String lactoflavin;
    @SerializedName("lactoflavinUnit")
    public String lactoflavinUnit;
    @SerializedName("vitaminB6")
    public String vitaminB6;
    @SerializedName("vitaminB6Unit")
    public String vitaminB6Unit;
    @SerializedName("vitaminB12")
    public String vitaminB12;
    @SerializedName("vitaminB12Unit")
    public String vitaminB12Unit;
    @SerializedName("vitaminC")
    public String vitaminC;
    @SerializedName("vitaminCUnit")
    public String vitaminCUnit;
    @SerializedName("niacin")
    public String niacin;
    @SerializedName("niacinUnit")
    public String niacinUnit;
    @SerializedName("folacin")
    public String folacin;
    @SerializedName("folacinUnit")
    public String folacinUnit;
    @SerializedName("pantothenic")
    public String pantothenic;
    @SerializedName("pantothenicUnit")
    public String pantothenicUnit;
    @SerializedName("biotin")
    public String biotin;
    @SerializedName("biotinUnit")
    public String biotinUnit;
    @SerializedName("choline")
    public String choline;
    @SerializedName("cholineUnit")
    public String cholineUnit;
    @SerializedName("phosphor")
    public String phosphor;
    @SerializedName("phosphorUnit")
    public String phosphorUnit;
    @SerializedName("kalium")
    public String kalium;
    @SerializedName("kaliumUnit")
    public String kaliumUnit;
    @SerializedName("magnesium")
    public String magnesium;
    @SerializedName("magnesiumUnit")
    public String magnesiumUnit;
    @SerializedName("calcium")
    public String calcium;
    @SerializedName("calciumUnit")
    public String calciumUnit;
    @SerializedName("iron")
    public String iron;
    @SerializedName("ironUnit")
    public String ironUnit;
    @SerializedName("zinc")
    public String zinc;
    @SerializedName("zincUnit")
    public String zincUnit;
    @SerializedName("iodine")
    public String iodine;
    @SerializedName("iodineUnit")
    public String iodineUnit;
    @SerializedName("selenium")
    public String selenium;
    @SerializedName("seleniumUnit")
    public String seleniumUnit;
    @SerializedName("copper")
    public String copper;
    @SerializedName("copperUnit")
    public String copperUnit;
    @SerializedName("fluorine")
    public String fluorine;
    @SerializedName("fluorineUnit")
    public String fluorineUnit;
    @SerializedName("manganese")
    public String manganese;
    @SerializedName("manganeseUnit")
    public String manganeseUnit;
    @SerializedName("healthLight")
    public Integer healthLight;
    @SerializedName("healthTips")
    public String healthTips;
    @SerializedName("healthSuggest")
    public String healthSuggest;
    @SerializedName("glycemicInfoData")
    public GlycemicInfoDataDTO glycemicInfoData;

    public static DataDTO objectFromData(String str) {

        return new Gson().fromJson(str, DataDTO.class);
    }
}
