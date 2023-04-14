package 模板方法模式;

//template 封装一套流程模板，让具体的制作流程继承且实现
public class Template {
    Beverage beverage; //接口用来接收实现类

    public void MakeBeverage(){
        if (beverage==null){
            return;
        }
        beverage.BoilWater();
        beverage.Brew();
        beverage.PourInCup();
        if (beverage.WantAddThings()){
            beverage.AddThings();
        }
    }
}
