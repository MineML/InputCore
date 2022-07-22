# How to register InputCore ?
```
@Override
    public void onEnable() {
        RegisterInputCore(this);
    }
```
# How to use InputCore ?
```
//Assign a value to the player variable
Player p = Bukkit.getPlayer("NguyeKhoi");
//Create InputType: InputType_All, InputType_Number, InputType_Text
InputType_Number in = new InputType_Number() {
  @Override
  public void run(InputEvent event) {
    //Code you want to run when player input
  }
};
//Set required condition for input
//Input must be positive
in.setNumberType(InputEnums.NumberType.POSITIVE);
//Input must be a double
in.setNumberFormat(InputEnums.NumberFormat.DOUBLE);
//Initiate player input
InputCatch(p, in);
```
# Maven
```
<repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io</url>
</repository>
```
```
<dependency>
  <groupId>com.github.NguyenPhucAnhKhoi</groupId>
  <artifactId>InputCore</artifactId>
  <version>Version</version>
</dependency>
```

[![](https://jitpack.io/v/NguyenPhucAnhKhoi/InputCore.svg)](https://jitpack.io/#NguyenPhucAnhKhoi/InputCore)
