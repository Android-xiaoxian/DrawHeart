package fsx.heart.drawheart;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author FANG SHIXIAN
 * @date 2020/9/8.
 * description：
 */
public class JavaTest {

    public static void main(String[] args) {
        List<TableInfo> tableInfos = new ArrayList<>();
        TableInfo tableInfo = new TableInfo("图形",80,new Worker());
        tableInfos.add(tableInfo);
        tableInfos.add(tableInfo);
        tableInfos.add(tableInfo);
        tableInfos.add(tableInfo);
    }

}

class TableInfo {
    /**
     * 实体类属性用private修饰，调用可以用get、set方法
     * get、set方法编译器可以用快捷键创建 Android Studio是Alt + Ins
     * eclipse应该也是
     */
    private String shape;
    private int height;
    private Worker owner;

    TableInfo() {
    }

    TableInfo(String shape, int height,Worker owner) {
        this.shape = shape;
        this.height = height;
        this.owner = owner;
        System.out.println(" new TableInfo");
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Worker getOwner() {
        return owner;
    }

    public void setOwner(Worker owner) {
        this.owner = owner;
    }

    public void print() {
        System.out.println("This is zhangsan's table");
    }
}

class Worker {
    private String name;
    private TableInfo table;

    Worker() {
        System.out.println(" new Worker");
    }

    public void setTable(TableInfo table) {
        this.table = table;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TableInfo getTable() {
        return table;
    }

    Worker(String name, TableInfo table) {
        this.name = name;
        this.table = table;
    }

    void print() {
        System.out.println("zhangsan has a square table");
    }
}
