package com.shijing.nopainnogain.designpattern.facadepattern;

public class TeaHouseFacade {
    private String name;
    private TeasetService teasetService;
    private KettleService kettleService;

    public TeaHouseFacade(String name) {
        this.name = name;
        this.teasetService = new TeasetService();
        this.kettleService = new KettleService();
    }

    public TeaWater makeTea(int teaNumber) {
        switch (teaNumber) {
            case 1:
                Water water1 = new Water();
                TeaLeaf teaLeaf1 = new TeaLeaf("西湖龙井");
                kettleService.waterBurning(this.name, water1, 4);
                TeaWater teawater1 = teasetService.makeTeaWater(this.name, water1, teaLeaf1);
                return teawater1;
            case 2:
                Water water2 = new Water(10, 15);
                TeaLeaf teaLeaf2 = new TeaLeaf("碧螺春");
                kettleService.waterBurning(this.name, water2, 4);
                TeaWater teawater2 = teasetService.makeTeaWater(this.name, water2, teaLeaf2);
                return teawater2;
            default:
                Water water3 = new Water();
                TeaLeaf teaLeaf3 = new TeaLeaf("招牌乌龙");
                kettleService.waterBurning(this.name, water3, 5);
                TeaWater teawater3 = teasetService.makeTeaWater(this.name, water3, teaLeaf3);
                return teawater3;
        }
    }
}

