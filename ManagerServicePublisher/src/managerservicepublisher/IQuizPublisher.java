package managerservicepublisher;

public interface IQuizPublisher {
    /**
     * add new quizzes to the quiz list
     */
    public void addNewProduct();

    /**
     * get the quiz list
     */
    public void displayProducts();

  
    /**
     * remove a quiz from the quiz list
     */
    public void removeProduct();

    /**
     * update a selected quiz
     */
    public void updateProduct();

    
}

