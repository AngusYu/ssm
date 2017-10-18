package cn.angusyu.test.ssm.util.enums;

/**
 * The enum Appoint state enum.
 * @author AngusYu
 */
public enum  AppointStateEnum {

    /**
     *
     */
    SUCCESS(1, "Appoint Success"), OUT_OF_STOCK(0, "Out of Stock"), REPEATED_APPOINTMENT(-1, "Repeated appointment"), SYSTEM_ERROR(-2, "System Error");

    private int state;
    private String stateInfo;

    AppointStateEnum(int state, String stateInfo){
        this.state=state;
        this.stateInfo=stateInfo;
    }

    public int getState(){
        return state;
    }

    public String getStateInfo(){
        return stateInfo;
    }

    public static AppointStateEnum stateOf(int index){
        for (AppointStateEnum appointStateEnum : values()) {
            if (appointStateEnum.getState() == index){
                return appointStateEnum;
            }
        }
        return null;
    }
}
