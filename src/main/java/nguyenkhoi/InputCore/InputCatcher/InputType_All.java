package nguyenkhoi.InputCore.InputCatcher;

import java.util.Arrays;
import java.util.List;

public abstract class InputType_All implements InputExecute{
    private InputEnums.InputMethod method = InputEnums.InputMethod.ONE;
    private String start = "&ePlease type what you want in the chat. Type cancel/stop to cancel input process.";
    private String cancel = "&cYou canceled the input process!";
    private List<String> cancels = Arrays.asList("cancel", "stop");

    public InputEnums.InputMethod getMethod() {
        return method;
    }

    public String getStart() {
        return start;
    }

    public String getCancel() {
        return cancel;
    }

    public List<String> getCancelList() {
        return cancels;
    }

    public void setMethod (InputEnums.InputMethod inputMethod) {
        this.method = inputMethod ;
    }

    public void setStart (String s) {
        this.start = s;
    }

    public void setCancel (String s) {
        this.cancel = s;
    }

    public void setCancelList (List<String> cancel) {
        this.cancels = cancel;
    }
}
