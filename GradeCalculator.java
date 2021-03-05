/*
 * GradeCalculator.java
 * Author:  Evan Eastabrooks 
 * Submission Date:  3/5/2021
 *
 * Purpose: GradeCalculator.java asks the user for their grades
 * over the course of the semester in order to calculate a couple
 * of things. The program calculates what the user's final grade
 * in the class is if they know all of their grades. It can also
 * calculate what they will need on the rest of their assignments
 * in order to obtain a desired grade set by the user. If that 
 * grade is unattainable the program will tell the user that.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this assignment is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */

import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {
		
		System.out.println("Grading Scale:");
		System.out.println("A\t90 - 100");
		System.out.println("B\t80 - 89");
		System.out.println("C\t70 - 79");
		System.out.println("D\t60 - 69");
		System.out.println("F\tbelow 60");
		
		//initializations
		String typedGrade,desiredGrade = "";
		int exam1Weight,exam2Weight,finalExamWeight,labsWeight,projectsWeight,participationWeight,quizWeight,finalOverallScore = 0;
		
		//Prompting the user for their desired course grade
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What letter grade do you want to achieve for the course?");
		typedGrade = keyboard.next();
		if(typedGrade.equalsIgnoreCase("A")) {
			desiredGrade = "A";
			finalOverallScore = 90;} //The minimum grade needed to achieve the desired grade
		else if(typedGrade.equalsIgnoreCase("B")) {
			desiredGrade = "B";
			finalOverallScore = 80;}
		else if(typedGrade.equalsIgnoreCase("C")) {
			desiredGrade = "C";
			finalOverallScore = 70;}
		else if(typedGrade.equalsIgnoreCase("D")) {
			desiredGrade = "D";
			finalOverallScore = 60;}
		else if(typedGrade.equalsIgnoreCase("F")) {
			desiredGrade = "F";
			finalOverallScore = 0;}
		else {
			System.out.println("The input is invalid.");
			System.exit(0);}
		
		//Asking for the weights of each assignment category
		System.out.println("Enter percentage weights below.");
		System.out.print("Exam 1:\t\t\t");
		exam1Weight = keyboard.nextByte();
		System.out.print("Exam 2:\t\t\t");
		exam2Weight = keyboard.nextByte();
		System.out.print("Final Exam:\t\t");
		finalExamWeight = keyboard.nextByte();
		System.out.print("Labs:\t\t\t");
		labsWeight = keyboard.nextByte();
		System.out.print("Projects:\t\t");
		projectsWeight = keyboard.nextByte();
		System.out.print("Participation:\t\t");
		participationWeight = keyboard.nextByte();
		System.out.print("Quizzes:\t\t");
		quizWeight = keyboard.nextByte();
		
		//Calculates if the weights add up to 100. Exits if not
		int weight = exam1Weight+exam2Weight+finalExamWeight+labsWeight+projectsWeight+participationWeight+quizWeight;
		if(weight != 100) {
			System.out.println("Weights don’t add up to 100, program exiting...");
			System.exit(0);}
		
		int exam1Score = 0,exam2Score = 0,finalExamScore = 0,labAverageScore = 0,projectAverageScore = 0,participationAverageScore = 0,quizAverageScore = 0;
		int totalKnownGradeWeight = 0;
		
		//Asking user if they know each assignment grade. If they don't know one, it skips to the next
		System.out.print("Do you know your exam 1 score?");
		String knowExam1 = keyboard.next().toLowerCase();
		switch(knowExam1) {
		case"y":
		case"yes":
			System.out.print("Score received on exam 1:");
			exam1Score = keyboard.nextInt();
			totalKnownGradeWeight += exam1Weight;
			break;
		default:
			break;}
		System.out.print("Do you know your exam 2 score?");
		String knowExam2 = keyboard.next().toLowerCase();
		switch(knowExam2) {
		case"y":
		case"yes":
			System.out.print("Score received on exam 2:");
			exam2Score = keyboard.nextInt();
			totalKnownGradeWeight += exam2Weight;
			break;
		default:
			break;}
		System.out.print("Do you know your final exam score?");
		String knowFinalExam = keyboard.next().toLowerCase();
		switch(knowFinalExam) {
		case"y":
		case"yes":
			System.out.print("Score received on final exam:");
			finalExamScore = keyboard.nextInt();
			totalKnownGradeWeight += finalExamWeight;
			break;
		default:
			break;}
		System.out.print("Do you know your lab average?");
		String knowLabAverage = keyboard.next().toLowerCase();
		switch(knowLabAverage) {
		case"y":
		case"yes":
			System.out.print("Average lab grade:");
			labAverageScore = keyboard.nextInt();
			totalKnownGradeWeight += labsWeight;
			break;
		default:
			break;}
		System.out.print("Do you know your project average?");
		String knowProjectAverage = keyboard.next().toLowerCase();
		switch(knowProjectAverage) {
		case"y":
		case"yes":
			System.out.print("Average project grade:");
			projectAverageScore = keyboard.nextInt();
			totalKnownGradeWeight += projectsWeight;
			break;
		default:
			break;}
		System.out.print("Do you know your participation average?");
		String knowParticipationAverage = keyboard.next().toLowerCase();
		switch(knowParticipationAverage) {
		case"y":
		case"yes":
			System.out.print("Average participation grade:");
			participationAverageScore = keyboard.nextInt();
			totalKnownGradeWeight += participationWeight;
			break;
		default:
			break;}
		System.out.print("Do you know your quiz average?");
		String knowQuizAverage = keyboard.next().toLowerCase();
		switch(knowQuizAverage) {
		case"y":
		case"yes":
			System.out.print("Average quiz grade:");
			quizAverageScore = keyboard.nextInt();
			totalKnownGradeWeight += quizWeight;
			break;
		default:
			break;}
		
		//Calculating current score
		String currentLetterGrade = "";
		int weightgi = ((exam1Score*exam1Weight)+(exam2Score*exam2Weight)+(finalExamScore*finalExamWeight)+(labsWeight*labAverageScore)+(projectsWeight*projectAverageScore)+(participationWeight*participationAverageScore)+(quizWeight*quizAverageScore));
		double totalKnownGradeAverage = weightgi/totalKnownGradeWeight;
		
		//Deciding what letter grade the current score is
		if((totalKnownGradeAverage >= 90)&&(totalKnownGradeAverage <= 100)) {
			currentLetterGrade = "A";}
		else if((totalKnownGradeAverage >= 80)&&(totalKnownGradeAverage <= 89)) {
			currentLetterGrade = "B";}
		else if((totalKnownGradeAverage >= 70)&&(totalKnownGradeAverage <= 79)) {
			currentLetterGrade = "C";}
		else if((totalKnownGradeAverage >= 60)&&(totalKnownGradeAverage <= 69)) {
			currentLetterGrade = "D";}
		else if(totalKnownGradeAverage <= 59) {
			currentLetterGrade = "F";}
		
		//Calculating what grades on the remaining assignments are needed to achieve desired grade
		double avgToFinalLetterGrade = 0;
		avgToFinalLetterGrade = (100 * finalOverallScore - ((exam1Score*exam1Weight)+(exam2Score*exam2Weight)+(finalExamScore*finalExamWeight)+(labsWeight*labAverageScore)+(projectsWeight*projectAverageScore)+(participationWeight*participationAverageScore)+(quizWeight*quizAverageScore)));
		if(totalKnownGradeWeight != 100) {
			avgToFinalLetterGrade = avgToFinalLetterGrade/(100 - totalKnownGradeWeight);}
		
		//Print statements based on each case
		System.out.printf("Current grade score:%.2f\n",totalKnownGradeAverage);
		System.out.println("Your current letter grade:"+currentLetterGrade);
		if(currentLetterGrade.equalsIgnoreCase(desiredGrade)) {
			System.out.print("Congratulations! You recieved the "+desiredGrade);
			System.out.print(" that you wanted!"); 
			System.exit(0);}
		if((totalKnownGradeWeight != 100)&&(avgToFinalLetterGrade <= 100)&&(avgToFinalLetterGrade >= 0)) {
			System.out.println("In order to receive a grade of "+desiredGrade+",");
			System.out.println("you need to score an average greater than");
			System.out.printf("or equal to %.2f in the rest of the grade items.",avgToFinalLetterGrade);
			System.exit(0);}
		else if(avgToFinalLetterGrade<0) {
			System.out.println("You will recieve at least a "+desiredGrade);
			System.exit(0);}
		else {
			System.out.print("Unfortunately, a grade of "+desiredGrade+" is not possible.");
			System.exit(0);}
		
		keyboard.close();
	}

}
