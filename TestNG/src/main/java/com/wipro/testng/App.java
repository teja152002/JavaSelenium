package com.wipro.testng;

import java.util.*;

class Task {
	String name;
	int priority;

	public Task(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "Task: " + name + ", Priority: " + priority;
	}
}

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Task> taskList = new ArrayList<>();

		while (true) {
			if (taskList.size() >= 10) {
				System.out.println("Maximum of 10 tasks reached.");
				break;
			}

			String taskName = scanner.nextLine().trim();

			if (taskName.equalsIgnoreCase("done")) {
				if (taskList.size() < 5) {
					System.out.println("Please enter at least 5 tasks before typing 'done'.");
					continue;
				} else {
					break;
				}
			}

			if (taskName.isEmpty()) {
				System.out.println("Task name cannot be empty. Please try again.");
				continue;
			}
			
			int priority;
			try {
				priority = Integer.parseInt(scanner.nextLine().trim());
				if (priority < 1 || priority > 10) {
					System.out.println("Priority must be between 1 and 10. Try again.");
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Priority must be an integer between 1 and 10.");
				continue;
			}

			taskList.add(new Task(taskName, priority));
		}

		Collections.sort(taskList, new Comparator<Task>() {
			@Override
			public int compare(Task t1, Task t2) {
				return Integer.compare(t1.priority, t2.priority);
			}
		});

		for (Task task : taskList) {
			System.out.println(task);
		}

		scanner.close();
	}
}
