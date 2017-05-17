package courses;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static courses.Courses.*;


public class CoursesTest {

	public Courses courses = new Courses();

	@Test
	public void oneStudentInTwoCourses(){

		Student[] math = new Student[4];
		Student[] language = new Student[3];
		Student ana = new Student("Ana", "Kendrick", 21);
		Student george = new Student("George", "Washington", 23);
		Student john = new Student("John", "Adams", 25);
		Student thomas = new Student("Thomas", "Jefferson", 27);
		Student jim = new Student("Jim", "Carrey", 23);
		Student james = new Student("James", "Stewart", 29);

		math[0] = ana;
		math[1] = george;
		math[2] = john;
		math[3] = thomas;

		language[0] = george;
		language[1] = jim;
		language[2] = james;

		assertThat(courses.getStudentsInCommon(math, language), is(1));
	}

	@Test
	public void twoStudentInTwoCourses(){

		Student[] math = new Student[4];
		Student[] language = new Student[3];
		Student ana = new Student("Ana", "Kendrick", 21);
		Student george = new Student("George", "Washington", 23);
		Student john = new Student("John", "Adams", 25);
		Student thomas = new Student("Thomas", "Jefferson", 27);
		Student jim = new Student("Jim", "Carrey", 23);
		Student james = new Student("James", "Stewart", 29);

		math[0] = ana;
		math[1] = george;
		math[2] = john;
		math[3] = thomas;

		language[0] = george;
		language[1] = jim;
		language[2] = ana;

		assertThat(courses.getStudentsInCommon(math, language), is(2));
	}

	@Test
	public void allStudentsInTwoCourses(){

		Student[] math = new Student[6];
		Student[] language = new Student[6];
		Student ana = new Student("Ana", "Kendrick", 21);
		Student george = new Student("George", "Washington", 23);
		Student john = new Student("John", "Adams", 25);
		Student thomas = new Student("Thomas", "Jefferson", 27);
		Student jim = new Student("Jim", "Carrey", 23);
		Student james = new Student("James", "Stewart", 29);
		Student bruce = new Student("Bruce", "Willis", 29);

		math[0] = ana;
		math[1] = george;
		math[2] = john;
		math[3] = thomas;
		math[4] = jim;
		math[5] = bruce;

		language[0] = george;
		language[1] = jim;
		language[2] = ana;
		language[3] = bruce;
		language[4] = thomas;
		language[5] = john;

		assertThat(courses.getStudentsInCommon(math, language), is(6));
	}


}