
public class AllWork {

	public Task[] tasks;
	protected static int freePlacesForTasks;
	protected static int currentUnassignedTask;

	AllWork(int tasksNumber) {
		tasks = new Task[tasksNumber];
		freePlacesForTasks = tasksNumber;
		currentUnassignedTask = 0;
	}

	void addTask(Task newTask) {
		if (freePlacesForTasks == 0) {
			System.out.println("No more places for tasks!");
		} else {
			tasks[tasks.length-freePlacesForTasks--] = newTask;
			System.out.println(newTask.getName() + "has been add to All Work");
		}
	}

	Task getNextTask() {
		if (currentUnassignedTask > tasks.length) {
			System.out.println("no more tasks");
			return null;
		} else {
			return tasks[currentUnassignedTask];
		}
	}

	boolean isAllWorkDone() {
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i] != null) {
				if (tasks[i].getWorkingHours() == 0) {
					continue;
				} else {
					return false;
				}
			}
	
		}
		return true;
	}

}
