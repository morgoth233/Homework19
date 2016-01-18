public class Employee {

	private String name;
	private Task currentTask;
	private int hoursLeft;
	private static AllWork allwork;

	Employee(String name) {
		if (name.equals("")) {
			System.out.println("Invalid name");
		} else {
			this.name = name;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.equals("")) {
			System.out.println("Invalid name");
		} else {
			this.name = name;
		}
	}

	public Task getCurrentTask() {
		return currentTask;
	}

	public void setCurrentTask(Task currentTask) {
		if (currentTask != null) {
			this.currentTask = currentTask;
			AllWork.currentUnassignedTask++;
		}
	}

	public int getHoursLeft() {
		return hoursLeft;
	}

	public void setHoursLeft(int hoursLeft) {
		if (hoursLeft < 0) {
			System.out.println("Invalid number");
		} else {
			this.hoursLeft = hoursLeft;
		}
	}

	public static AllWork getAllwork() {
		return allwork;
	}

	public static void setAllwork(AllWork allwork) {
		Employee.allwork = allwork;
	}

	public void startWorkingDay() {
		this.hoursLeft = 8;
	}

	public void work() {
		if (this.getCurrentTask() != null
				&& this.getCurrentTask().getWorkingHours() > 0) {
			System.out.println(this.getName() + " starts to "
					+ this.getCurrentTask().getName());

			if (this.currentTask.getWorkingHours() - this.getHoursLeft() <= 0) {
				this.currentTask.setWorkingHours(0);
				System.out.println(this.getName() + " has finished "
						+ this.getCurrentTask().getName());
				this.setHoursLeft(this.getHoursLeft()
						- this.currentTask.getWorkingHours());
				this.setCurrentTask(allwork.getNextTask());
				this.work();
				
			} else {
				this.currentTask.setWorkingHours(this.currentTask
						.getWorkingHours() - this.getHoursLeft());
				this.setHoursLeft(0);
			}
		} else {
			System.out.println(this.getName() + " has no task for today");

		}
	}

	void showReport() {
		System.out.println(this.getName());
		System.out.println("Ime na zadacahta po koqto raboti "
				+ this.getCurrentTask().getName());
		System.out.println("Ostavashto vreme rabota po zadachata "
				+ this.getCurrentTask().getWorkingHours());
		System.out.println("Ostavashti rabotni chasove na rabotnika "
				+ this.getHoursLeft());
	}

}
