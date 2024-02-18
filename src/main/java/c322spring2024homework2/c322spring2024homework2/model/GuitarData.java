package c322spring2024homework2.c322spring2024homework2.model;

public class GuitarData {
    String serialNum;
    double price;
    String builder;
    String model;
    String type;
    String backWood;
    String topWood;

    public GuitarData(String serialNum, double price, String builder, String model, String type, String backWood, String topWood) {
        this.serialNum = serialNum;
        this.price = price;
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }
    public String toLine() {
        return String.format("%1$s,%2$s,%3$s,%4$s,%5$s,%6$s,%7$s", serialNum, price, builder, model, type, backWood, topWood);

    }
    public static GuitarData fromLine(String line) {
        String[] tokens = line.split(",");
        return new GuitarData(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
    }


    //gets serial num
    public String getSerialNumber(){
        return serialNum;
    }
    //gets price
    public double getPrice(){
        return price;
    }
    //sets the price
    public void setPrice(float p){
        price = p;

    }
    //gets the builder
    public String getBuilder(){
        return builder;
    }
    //gets the model
    public String getModel(){
        return model;
    }
    //gets the type
    public String getType(){
        return type;
    }
    //gets backwood
    public String getBackWood(){
        return backWood;
    }
    //gets topwood
    public String getTopWood(){
        return topWood;
    }
}