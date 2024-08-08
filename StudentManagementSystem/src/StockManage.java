import java.util.*;

public class StockManage {

    static String[][] user = {{"admin"},{"1234"}};
    static String[][] supplier = new String[2][0];
    static String[] itemCategory = new String[0];
    static String[][] item = new String[6][0];



    public static String[][] grow(String[][] old) {
        String[][] newArray = new String[old.length][old[0].length + 1];

        for (int i = 0; i < old.length; i++) {
            for (int j = 0; j < old[i].length; j++){
                newArray[i][j] = old[i][j];
            }
        }
        return newArray;
    }

    public static String[] grow(String[] oldArray) {
        String[] newArray = new String [oldArray.length + 1];

        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }



        public static void supplierManage(){
            System.out.println("+-----------------------------------------------+");
            System.out.println("|\t\t STUDENT MANAGE \t\t|");
            System.out.println("+-----------------------------------------------+\n");

            System.out.println("[1] Add supplier \t [2] Update supplier  \n[3] Delete supplier \t [4] View supplier \n[5] Search supplier \t [6] Home Page \n");

            System.out.print("Enter your option to continue > ");

            int opt = new Scanner(System.in).nextInt();

            L2:        do{

                switch (opt){

                    case 1:

                        addSupplier();

                        break;

                    case 2:

                        updateSupplier();

                        break;

                    case 3:

                        deleteSupplier();

                        break;

                    case 4:

                        viewSupplier();

                        break;

                    case 5:

                        searchSupplier();

                        break;

                    case 6:

                        break;

                    default:

                        System.out.println("Invalid option");

                        continue L2;

                }

            }while(true);

        }



        public static void addSupplier(){

            System.out.println("+-------------------------------------------------------+");
            System.out.println("|\t\t\t ADD SUPPLIER  \t\t\t|");
            System.out.println("+-------------------------------------------------------+\n");

            supplier = grow(supplier);
            supplierID();

        }



        public static void supplierID(){
            System.out.print("Enter Supplier ID: ");
            String supId = new Scanner(System.in).nextLine();

            int count = 0;



            for (int i = 0; i < supplier[0].length; i++){

                if (supId.equals(supplier[0][i])){

                    count++;

                }

            }

            if (count < 1 ){

                supplier[0][supplier[0].length - 1] = supId;

                supplierName();

            }else{

                System.out.println("Already exists. try another supplier id!\n");

                supplierID();

            }

        }



        public static void supplierName(){

            System.out.print("Enter Supplier Name: ");

            supplier[1][supplier[1].length - 1] = new Scanner(System.in).nextLine();


            System.out.print("Supplier added successfully! Do you want to add another supplier? (y/n): ");

            String res = new Scanner(System.in).nextLine();

            if (res.equals("y") || res.equals("Y")){

                addSupplier();

            }else{

                supplierManage();

            }

        }



    public static void updateSupplier(){
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|\t\t\t UPDATE SUPPLIER  \t\t\t|");
        System.out.println("+---------------------------------------------------------------+\n");
        updateSup();
    }

    public static void updateSup(){
        System.out.print("Supplier ID         : ");
        String id = new Scanner(System.in).nextLine();

        int count = 0;

        for (int i = 0; i < supplier[0].length; i++){
            if (id.equals(supplier[0][i])){
                System.out.println("Supplier name : " + supplier[1][i]);

                System.out.print("\nEnter the new supplier name : ");
                supplier[1][i] = new Scanner(System.in).nextLine();

                System.out.print("Updated successfully! Do you want to update another supplier? (Y/N) : ");
                String res = new Scanner(System.in).nextLine();

                if (res.equals("y") || res.equals("Y")){
                    updateSupplier();
                }else{
                    supplierManage();
                }
            }else{
                count++;
            }
        }
        if (count == supplier[0].length){
            System.out.println("Can't find supplier id. try again!");
            updateSup();
        }
    }

    public static void deleteSupplier(){
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|\t\t\t DELETE SUPPLIER  \t\t\t|");
        System.out.println("+---------------------------------------------------------------+\n");
        deleteSup();

    }

    public static void deleteSup(){
        System.out.print("Supplier ID \t: ");
        String res = new Scanner(System.in).nextLine();

        int count = 0;
        for (int i = 0; i < supplier[0].length; i++){

            if (res.equals(supplier[0][i])){
                supplier[0][i] = "null";
                supplier[1][i] = "null";
                System.out.print("Deleted successfully! Do you want to delete another? (Y/N) ");
                String ans = new Scanner(System.in).nextLine();
                if (ans.equals("Y") || ans.equals("y")){
                    deleteSupplier();
                }else{
                    supplierManage();
                }
            }else{
                count++;
            }
        }
        if (count == supplier[0].length){
            System.out.println("Can't find supplier id. try again");
            deleteSup();
        }
    }



        public static void viewSupplier(){
            System.out.println("+---------------------------------------------------------------+");

            System.out.println("|\t\t\t VIEW SUPPLIER  \t\t\t|");

            System.out.println("+---------------------------------------------------------------+\n");



            System.out.println("+----------------------+----------------------+");

            System.out.printf("| %-20s | %-20s |\n", "SUPPLIER ID", "SUPPLIER NAME");

            System.out.println("+----------------------+----------------------+");


            for (int i = 0; i < supplier[0].length; i++) {

                System.out.printf("| %-20s | %-20s |\n", supplier[0][i], supplier[1][i]);

            }


            System.out.println("+----------------------+----------------------+\n");


            System.out.print("Do you want to go to supplier manage page(Y/N)? ");

            String res = new Scanner(System.in).nextLine();



            if (res.equals("Y") || res.equals("y")){

                supplierManage();

            }else{
            }

        }



        public static void searchSupplier(){
            System.out.println("+---------------------------------------------------------------+");

            System.out.println("|\t\t\t SEARCH SUPPLIER  \t\t\t|");

            System.out.println("+---------------------------------------------------------------+\n");

            searchSup();

        }



        public static void searchSup(){



            System.out.print("Supplier ID \t: ");

            String res = new Scanner(System.in).nextLine();



            int count = 0;

            for (int i = 0; i < supplier[0].length; i++){

                if (res.equals(supplier[0][i])){

                    System.out.println("Supplier name : " + supplier[1][i]);



                    System.out.print("Searched successfully! Do you want to search another? (Y/N) ");

                    String ans = new Scanner(System.in).nextLine();

                    if (ans.equals("Y") || ans.equals("y")){

                        searchSupplier();

                    }else{

                        supplierManage();

                    }

                }else{

                    count++;

                }

            }

            if (count == supplier[0].length){

                System.out.println("Can't find supplier id. try again\n");

                searchSup();

            }

        }



        public static void stockManage(){
            System.out.println("+---------------------------------------------------------------+");

            System.out.println("|\t\t\t STOCK MANAGEMENT  \t\t\t|");

            System.out.println("+---------------------------------------------------------------+\n");



            System.out.println("[1] Manage Item Categories \t [2] Add Item \n[3] Get Items Supplier Wise \t [4] View Items \n[5] Rank Items Per Unit Price \t [6] Home Page \n");

            System.out.print("Enter an option to continue > ");

            int opt = new Scanner(System.in).nextInt();

            L3:        do{

                switch (opt){

                    case 1:

                        manageItemCategory();

                        break;

                    case 2:

                        addItem();

                        break;

                    case 3:

                        itemsSupplierWise();

                        break;

                    case 4:

                        viewItems();

                        break;

                    case 5:

                        rankItems();

                        break;

                    case 6:
                        break;

                    default:

                        System.out.println("Not an option");

                        continue L3;

                }

            }while(true);

        }



        public static void manageItemCategory(){
            System.out.println("+---------------------------------------------------------------+");

            System.out.println("|\t\t\t MANAGE ITEM CATEGORY  \t\t\t|");

            System.out.println("+---------------------------------------------------------------+\n");



            System.out.println("[1] Add New Item Category \t [2] Delete Item Category \n[3] Update Item Category \t [4] Stock Management \n");

            System.out.print("Enter an option to continue > ");

            int opt = new Scanner(System.in).nextInt();



            L4:        do{

                switch (opt){

                    case 1:

                        addNewItemCategory();

                        break;

                    case 2:

                        deleteItemCategory();

                        break;

                    case 3:

                        updateItemCategory();

                        break;

                    case 4:

                        stockManage();

                        break;

                    default:

                        System.out.println("Not an option");

                        continue L4;

                }

            }while(true);

        }



        public static void addNewItemCategory(){
            System.out.println("+---------------------------------------------------------------+");

            System.out.println("|\t\t\t ADD ITEM CATEGORY  \t\t\t|");

            System.out.println("+---------------------------------------------------------------+\n");



            System.out.print("Enter the new item category : ");

            String cat = new Scanner(System.in).nextLine();



            for (int i = 0; i < itemCategory.length; i++){



            }



            itemCategory = grow(itemCategory);

            itemCategory[itemCategory.length - 1] = cat;



            System.out.print("added successfully! Do you want to add another category (Y/N)? ");

            String res = new Scanner(System.in).nextLine();

            if (res.equals("Y") || res.equals("y")){

                addNewItemCategory();

            }else{

                stockManage();

            }

        }



        public static void deleteItemCategory(){
            System.out.println("+---------------------------------------------------------------+");

            System.out.println("|\t\t\t DELETE ITEM CATEGORY  \t\t\t|");

            System.out.println("+---------------------------------------------------------------+\n");

            deleteItemCat();

        }



        public static void deleteItemCat(){



            System.out.print("Item category : ");

            String res = new Scanner(System.in).nextLine();



            int count = 0;

            for (int i = 0; i < itemCategory.length; i++){

                if (res.equals(itemCategory[i])){

                    itemCategory[i] = "null" ;

                    System.out.print("Deleted successfully! Do you want to delete another? (Y/N) ");

                    String ans = new Scanner(System.in).nextLine();

                    if (ans.equals("Y") || ans.equals("y")){

                        deleteItemCategory();

                    }else{

                        stockManage();

                    }

                }else{

                    count++;

                }

            }

            if (count == itemCategory.length){

                System.out.println("Can't find item Category. try again");

                deleteItemCat();

            }



        }



        public static void updateItemCategory(){
            System.out.println("+---------------------------------------------------------------+");

            System.out.println("|\t\t\t UPDATE ITEM CATEGORY  \t\t\t|");

            System.out.println("+---------------------------------------------------------------+\n");

            updateItemCat();



        }



        public static void updateItemCat(){

            System.out.print("Item category        : ");

            String cat = new Scanner(System.in).nextLine();



            int count = 0;



            for (int i = 0; i < itemCategory.length; i++){

                if (cat.equals(itemCategory[i])){



                    System.out.print("\nEnter the new item category name : ");

                    itemCategory[i] = new Scanner(System.in).nextLine();



                    System.out.print("Updated successfully! Do you want to update another? (Y/N) : ");

                    String res = new Scanner(System.in).nextLine();



                    if (res.equals("y") || res.equals("Y")){

                        updateItemCategory();

                    }else{

                        stockManage();

                    }

                }else{

                    count++;

                }

            }

            if (count == itemCategory.length){

                System.out.println("Can't find item category. try again!");

                updateItemCat();

            }

        }



        public static void addItem(){
            System.out.println("+------------------------------------------------------------------------------+");

            System.out.println("|\t\t\t           ADD ITEM             \t\t\t|");

            System.out.println("+------------------------------------------------------------------------------+\n");

            checkCatAndSup();

            addNewItem();



        }



    public static void checkCatAndSup(){

        if (itemCategory.length == 0){

            System.out.print("OOPS! It seems that you don't have any item categories in the system.Do you want to add a new item category? (Y/N) : ");

            String res = new Scanner(System.in).nextLine();

            if (res.equals("Y") || res.equals("y")){

                addNewItemCategory();

            }else if (res.equals("n") || res.equals("N")){

                stockManage();

            }else{

                System.out.println("Wrong input! Try again\n");

                checkCatAndSup();

            }

        }



        if (supplier[0].length == 0){

            System.out.print("OOPS! It seems that you don't have any suppliers in the system.Do you want to add a new supplier? (Y/N) : ");

            String res = new Scanner(System.in).nextLine();

            if (res.equals("Y") || res.equals("y")){

                addSupplier();

            }else if (res.equals("n") || res.equals("N")){

                stockManage();

            }else{

                System.out.println("Wrong input! Try again");

                checkCatAndSup();

            }

        }

    }



    public static void addNewItem(){
        System.out.print("Item Code : ");

        String itemCode = new Scanner(System.in).nextLine();

        int count = 0;



        for (int i = 0; i < item[0].length; i++){

            if (!itemCode.equals(item[0][i])){

                count++;

            }else{

                System.out.println("Already exists. try again");

                addNewItem();

            }

        }

        if (count == item[0].length){

            item = grow(item);

            item[0][item[0].length-1] = itemCode;

        }

        System.out.println("Supplier List : ");
        System.out.println("+----------------------+----------------------+----------------------+");
        System.out.printf("| %-20s | %-20s | %-20s |\n", "ID", "SUPPLIER ID", "SUPPLIER NAME");
        System.out.println("+----------------------+----------------------+----------------------+");

        for (int i = 0; i < supplier[0].length; i++) {
            System.out.printf("| %-20s | %-20s | %-20s |\n", (i + 1), supplier[0][i], supplier[1][i]);
        }

        System.out.println("+----------------------+----------------------+----------------------+\n");

        System.out.print("Enter the supplier number : ");
        String supNoInput = new Scanner(System.in).nextLine();
        int supNo = Integer.parseInt(supNoInput);

        for (int i = 0; i < supplier[0].length; i++){
            if (supNo == i + 1) {
                item[4][item[4].length-1] = supplier[0][i];
            }
        }

        System.out.println(" ");
        System.out.println("+----------------------+----------------------+");
        System.out.printf("| %-20s | %-20s |\n", "ID", "CATEGORY NAME");
        System.out.println("+----------------------+----------------------+");
        for (int i = 0; i < itemCategory.length; i++) {
            System.out.printf("| %-20s | %-20s |\n", (i + 1), itemCategory[i]);
        }

        System.out.println("+----------------------+----------------------+\n");

        System.out.print("Enter the category number : ");
        String catNoInput = new Scanner(System.in).nextLine();
        int catNo = Integer.parseInt(catNoInput);
        for (int i = 0; i < itemCategory.length; i++) {
            if (catNo == i + 1) {
                item[5][item[5].length - 1] = itemCategory[i];
            }
        }

        System.out.println();
        System.out.print("Description \t: ");
        String desc = new Scanner(System.in).nextLine();
        item[1][item[1].length-1] = desc;

        System.out.print("Unit Price \t: ");
        String uPrice = new Scanner(System.in).nextLine();
        item[2][item[2].length-1] = uPrice;

        System.out.print("Qty on hand \t: ");
        String qty = new Scanner(System.in).nextLine();
        item[3][item[3].length-1] = qty;

        System.out.print("added successfully! Do you want to add another Item(Y/N)? ");
        String res = new Scanner(System.in).nextLine();

        if (res.equals("y") || res.equals("Y")){
            addItem();
        }else{
            stockManage();
        }
    }

    public static void itemsSupplierWise(){
        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t          SEARCH SUPPLIER         \t\t\t|");
        System.out.println("+------------------------------------------------------------------------------+\n");

        System.out.print("Enter supplier ID: ");
        String id = new Scanner(System.in).nextLine();
        int count = 0;
        for (int i = 0; i < supplier[0].length; i++){
            if (id.equals(supplier[0][i])){
                System.out.println("Supplier Name : " + supplier[1][i]);
            }else{
                count++;
            }
        }

        if (count == supplier[0].length){
            System.out.println("Can't find supplier. try again");
        }

        System.out.println("+------------+-----------------+------------+-----------------+------------+");
        System.out.printf("| %-10s | %-15s | %-10s | %-15s | %-10s |\n", "ITEM CODE", "DESCRIPTION", "UNIT PRICE", "QTY ON HAND", "CATEGORY");
        System.out.println("+------------+-----------------+------------+-----------------+------------+");

        for (int i = 0; i < item[4].length; i++) {
            if (id.equals(item[4][i])) {
                System.out.printf("| %-10s | %-15s | %-10s | %-15s | %-10s |\n", item[0][i], item[1][i], item[2][i], item[3][i], item[5][i]);
            }
        }
        System.out.println("+------------+-----------------+------------+-----------------+------------+\n");

        System.out.print("search successfully! Do you want to search another (Y/N)? ");
        String res = new Scanner(System.in).nextLine();

        if (res.equals("Y") || res.equals("y")){
            itemsSupplierWise();
        }else{
            stockManage();
        }
    }

    public static void viewItems(){
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|\t\t\t VIEW ITEMS  \t\t\t|");
        System.out.println("+-------------------------------------------------------+\n");

        for (int i = 0; i < itemCategory.length; i++){
            System.out.println(itemCategory[i]);
            System.out.println("+------------+-----------------+------------+-----------------+------------+");
            System.out.printf("| %-10s | %-15s | %-10s | %-15s | %-10s |\n", "SID", "CODE", "DESC", "PRICE", "QUANTITY");
            System.out.println("+------------+-----------------+------------+-----------------+------------+");

            for (int j = 0; j < item[0].length; j++){
                if (itemCategory[i].equals(item[5][j])){

                    System.out.printf("| %-10s | %-15s | %-10s | %-15s | %-10s |\n", item[4][j], item[0][j], item[1][j], item[2][j], item[3][j]);
                }
            }
            System.out.println("+------------+-----------------+------------+-----------------+------------+");
        }

        System.out.print("Do you want to go to stock manage page(Y/N)? ");
        String res = new Scanner(System.in).nextLine();

        if (res.equals("Y") || res.equals("y")){
            stockManage();
        }else{
        }
    }

    public static void rankItems() {
        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t           RANKED UNIT PRICE             \t\t\t|");
        System.out.println("+------------------------------------------------------------------------------+\n");
        printrank();

    }

    public static void printrank() {

        if (item[0].length >= 1) {
            System.out.println("+-----------------------------------------------------------------------------+");
            System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n", "SID", "CODE", "DESC", "PRICE", "QTY", "CAT");
            System.out.println("+-----------------------------------------------------------------------------+");

            for (int j = 0; j < item[0].length - 1; j++) {
                for (int i = 0; i < item[0].length - 1; i++) {
                    int pr1 = Integer.parseInt(item[2][i]);
                    int pr2 = Integer.parseInt(item[2][i + 1]);

                    if (pr1 > pr2) {
                        for (int k = 0; k < item.length; k++) {
                            String temp = item[k][i];
                            item[k][i] = item[k][i + 1];
                            item[k][i + 1] = temp;
                        }
                    }
                }
            }

            for (int i = 0; i < item[0].length; i++) {
                System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n", item[4][i], item[0][i], item[1][i], item[2][i], item[3][i], item[5][i]);
            }
            System.out.println("+-----------------------------------------------------------------------------+");

        } else {
            System.out.print("There is no item added! Do you want to add items? (Y/N) :");
            String res = new Scanner(System.in).nextLine();

            if (res.equalsIgnoreCase("Y")) {
                addItem();
            } else if (res.equalsIgnoreCase("N")) {
                stockManage();
            } else {
                System.out.print("Wrong input!\n");
                printrank();
            }
        }

        do {
            System.out.print("Do you want to go back to Stock Manage Page? (Y/N)  :  ");
            String check = new Scanner(System.in).nextLine();
            System.out.println();

            if (check.equalsIgnoreCase("Y")) {
                stockManage();
            } else if (check.equalsIgnoreCase("N")) {
            } else {
                System.out.println("Wrong input...");
                continue;
            }
        } while (true);
    }

    public static void main(String args[]){
    }

}
