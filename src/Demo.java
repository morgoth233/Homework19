public class Demo {

	// zadachata ne e syvsem gotova i ne raboti kakto trqbva, shte si q doopravq
	// v git

	public static void main(String[] args) {
		int day = 0;
		Task study = new Task("study", 9);
		Task clean = new Task("clean", 16);
		Task sleep = new Task("sleep", 24);
		Task workout = new Task("workout", 32);
		Task fight = new Task("fight", 34);
		Task eat = new Task("eat", 44);
		Task drink = new Task("drink", 54);
		Task read = new Task("read", 12);
		Task code = new Task("code", 24);
		Task draw = new Task("draw", 16);

		AllWork allTasks = new AllWork(11);
		Employee.setAllwork(allTasks);

		allTasks.addTask(study);
		allTasks.addTask(clean);
		allTasks.addTask(sleep);
		allTasks.addTask(workout);
		allTasks.addTask(fight);
		allTasks.addTask(eat);
		allTasks.addTask(drink);
		allTasks.addTask(read);
		allTasks.addTask(code);
		allTasks.addTask(draw);

		Employee misho = new Employee("Misho");
		Employee pesho = new Employee("Pesho");
		Employee gosho = new Employee("Gosho");
		Employee kiro = new Employee("Kiril");

		Employee[] AllEmploiees = new Employee[4];
		AllEmploiees[0] = misho;
		AllEmploiees[1] = pesho;
		AllEmploiees[2] = gosho;
		AllEmploiees[3] = kiro;

		// misho.setCurrentTask(allTasks.getNextTask());
		//
		// pesho.setCurrentTask(allTasks.getNextTask());
		//
		// gosho.setCurrentTask(allTasks.getNextTask());
		//
		// kiro.setCurrentTask(allTasks.getNextTask());
		//
		for (int i = 0; i < AllEmploiees.length; i++) {// zadavat se na vseki
														// rabotnik zadacha
			AllEmploiees[i].setCurrentTask(allTasks.getNextTask());
		}
		

//		System.out.println(allTasks.getNextTask().getName());
//		System.out.println(Employee.getAllwork());
		//System.out.println(allTasks.tasks[allTasks.currentUnassignedTask].getName());

		while (!(allTasks.isAllWorkDone())) {
			day++;
			System.out.printf("work day %d starts \n", day);
			for (int i = 0; i < AllEmploiees.length; i++) {
				AllEmploiees[i].startWorkingDay();
				AllEmploiees[i].work();
				if(allTasks.isAllWorkDone()){
					System.out.println("all tasks are finished");
				}
			}
			
		}
//		for (int i = 0; i < allTasks.tasks.length && allTasks.tasks[i]!=null; i++) { // Check if all Tasks time is 0
//			System.out.println(allTasks.tasks[i].getWorkingHours());
//		}
	}

}
