package bjit.academy;

public class Main {
    public static void main(String args[]){
        DBConnect dbObj = new DBConnect();
        dbObj.doConnectDB();

        CreateTable createTableObj = new CreateTable();
        createTableObj.createTable();

        InsertData insertIntoTableObj = new InsertData();
        insertIntoTableObj.insertData("00-30065", "Mohidul Islam");
        insertIntoTableObj.insertData("00-30066", "Sadia Ahmed");
        insertIntoTableObj.insertData("00-30067", "Rahul Sharma");
        insertIntoTableObj.insertData("00-30068", "Nadia Chowdhury");
        insertIntoTableObj.insertData("00-30069", "John Smith");
        insertIntoTableObj.insertData("00-30070", "Sarah Williams");


        ShowData showDataObj = new ShowData();
        showDataObj.showData("trainee");
    }
}

