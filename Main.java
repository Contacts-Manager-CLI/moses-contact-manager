import java.io.IOException;

interface Main {

    public static void main(String[] args) throws IOException {



        Boolean another = true;
        do{
            int userInput = controller.mainMenu();
            switch (userInput){
                case 1:
                    controller.viewList();
                    break;
                case 2:
                    controller.addContact();
                    break;
                case 3:
                    controller.searchContact();
                    break;
                case 4:
                    controller.deleteContact();
                    break;
                case 5:
                    controller.exit();
                    another = false;
                    break;
                default:
                    System.err.println("Entry is invalid; please enter a number from 1 to 5");
            }
        }while(another);
    }
}