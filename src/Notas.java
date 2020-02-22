public class Notas {
	int [] [] matriz;
	String [] nombreAsignaturas;
	String [] nombreAlumnos;
	
	//CONSTRUCTOR POR DEFECTO OK
	public Notas(){
		matriz=new int [30][6];	
		nombreAsignaturas = new String [6];
		nombreAlumnos = new String [30];

	}
	
	//CONSTRUCTOR POR PARAMETROS OK
	public Notas (int nAlumnos, int nAsignaturas){
		matriz=new int[nAlumnos][nAsignaturas];
		nombreAsignaturas = new String [nAsignaturas];
		nombreAlumnos = new String [nAlumnos];
	}
	
	//DEFINIR EL NOMBRE DE UNA ASIGNATURA OK
	public void setAsignatura(int posicion, String nnAsignatura){
		nombreAsignaturas[posicion]=nnAsignatura;
	}
	
	//DEFINIR EL NOMBRE DE UN ALUMNO OK
	public void setAlumno(int posicion, String nnAlumno){
		nombreAlumnos[posicion]=nnAlumno;
	}
	
	//ASIGNAR NOTA A UN ALUMNO OK
	public void setNotaAlumnoAsignatura(int pAlumno, int pAsignatura, int nNota){
		if(nNota>=0 && nNota<=10){
		matriz[pAlumno][pAsignatura]=nNota;
		}else{System.out.print("La nota es incorrecta");}
	}
	
	//OBTENER NOTA DE UN ALUMNO OK
	public int getNotaAlumnoAsignatura(int pAlumno, int pAsignatura){
		return matriz[pAlumno][pAsignatura];
	}
	
	//OBTENER LAS NOTAS DE UN ALUMNO CON LA POSICION OK
	public void getNotasAlumno (int posicion){
		for(int i=0;i<nombreAsignaturas.length;i++){
			System.out.print(getNotaAlumnoAsignatura(posicion,i)+" ");
		}
	}
	
	//OBTENER LAS NOTAS DE UN ALUMNO CON EL NOMBRE OK
	public void getNotasAlumno (String nombreAlumnoaBuscar){
		for(int i=0;i<nombreAsignaturas.length;i++){
			if(nombreAlumnos[i]==nombreAlumnoaBuscar){
				getNotasAlumno(i);
			}
		}
	}
	
	//OBTENER LAS NOTAS DE UNA ASIGNATURA CON LA POSICION OK
	public void getNotasAsignatura (int posicion){
		for(int i=0;i<nombreAlumnos.length;i++){
			System.out.print(getNotaAlumnoAsignatura(i,posicion)+" ");
		}
	}
	
	//OBTENER LAS NOTAS DE UNA ASIGNATURA CON EL NOMBRE
	public void getNotasAsignatura (String nombreAsignaturaaBuscar){
		for(int i=0;i<nombreAsignaturas.length;i++){
			if(nombreAsignaturas[i]==nombreAsignaturaaBuscar){
					getNotasAsignatura(i);
			}
		}
	}
	
	//SUSPENSOS DE UN ALUMNO OK
	public int supensosAlumno (int posicion){
		int suspenso=0;
		for(int i=0;i<nombreAsignaturas.length;i++){
			if(getNotaAlumnoAsignatura(posicion, i)<5){suspenso++;}
		}
		return suspenso;
	}
	
	//SUSPENSOS DE UNA ASIGNATURA OK
	public int supensosAsignatura (int posicion){
		int suspenso=0;
		for(int i=0;i<nombreAlumnos.length;i++){
			if(getNotaAlumnoAsignatura(i, posicion)<5){
				suspenso++;
			}
		}
		return suspenso;
	}
	
	//MEDIA DE UN ALUMNO OK
	private double MediaAlumno (int posicion){
		double media=0;
		for(int i=0;i<nombreAsignaturas.length;i++){
			media+=getNotaAlumnoAsignatura(posicion,i);
		}
		
		media=media/nombreAsignaturas.length;
		return media; 	
	}
	
	//MEDIA DE UNA ASIGNATURA OK
	private double MediaAsignatura (int posicion){
		double media=0;
		for(int i=0;i<nombreAlumnos.length;i++){
			media+=getNotaAlumnoAsignatura(i,posicion);
		}
		
		media=media/nombreAlumnos.length;
	
		return media; 	
	}
	
	//BOLETÍN DE LA CLASE OK
	
	public void MostrarBoletinClase (){
		System.out.print("Asignaturas: ");
		for(int i=0;i<nombreAsignaturas.length;i++){
			System.out.print(i+" ");	
		}

		System.out.println(" ");
		for(int i=0;i<nombreAlumnos.length;i++){
			System.out.print(nombreAlumnos[i]+" ");
			getNotasAlumno(i);
			System.out.println(" ");
		}
		System.out.println(" ");
		for(int i=0;i<nombreAsignaturas.length;i++){
			System.out.print(i+" ");
			System.out.println(nombreAsignaturas[i]);		
		}
	}
	//BOLETIN DE UN ALUMNO
	public void MostrarBoletinAlumno(int posicion){
		System.out.println(nombreAlumnos[posicion]);
		for(int i=0;i<nombreAsignaturas.length;i++){
			System.out.print(nombreAsignaturas[i]);
			System.out.println(" "+ getNotaAlumnoAsignatura(posicion, i));
		}
		System.out.println("Total de suspensos: "+supensosAlumno(posicion));
		System.out.println("Nota media: "+MediaAlumno(posicion));
	}
	
	//RESUMEN DE UNA ASIGNATURA
	public void MostrarResumenAsignatura(int posicion){
		System.out.println(nombreAsignaturas[posicion]);
		for(int i=0;i<nombreAlumnos.length;i++){
			System.out.print(nombreAlumnos[i]);
			System.out.println(" "+ getNotaAlumnoAsignatura(i, posicion));
		}
		System.out.println("Total de suspensos: "+supensosAsignatura(posicion));
		System.out.println("Nota media: "+MediaAsignatura(posicion));
	}
	
	//TRANSPUESTA
	
	public int [][] matrizNotasTranspuesta(){
		int [][] transpuesta= new int[nombreAsignaturas.length] [nombreAlumnos.length];
		
		for(int i=0;i<transpuesta.length;i++){
			for(int j=0;j<transpuesta[i].length;j++){
				transpuesta [i][j]=matriz[j][i];
			}
		}
		return transpuesta;
	}
		
	public static void main (String[] args) {

		Notas primero=new Notas (3,2);
		primero.setAsignatura(0,"Programacion");
		primero.setAsignatura(1,"Base");
		primero.setAlumno(0,"Jose Luis");
		primero.setAlumno(1,"David");
		primero.setAlumno(2,"Jairo");
		primero.setNotaAlumnoAsignatura(0,0,1);
		primero.setNotaAlumnoAsignatura(0,1,2);
		primero.setNotaAlumnoAsignatura(1,0,3);
		primero.setNotaAlumnoAsignatura(1,1,4);
		primero.setNotaAlumnoAsignatura(2,0,5);
		primero.setNotaAlumnoAsignatura(2,1,6);
		
		System.out.println(primero.getNotaAlumnoAsignatura(0,1));
		primero.getNotasAlumno(1);
		System.out.println(" ");
		primero.getNotasAlumno("David");
		System.out.println(" ");
		primero.getNotasAsignatura(1);
		System.out.println(" ");
		primero.getNotasAsignatura("Base");
		System.out.println(" ");

		System.out.println(primero.supensosAlumno(1));
		System.out.println(primero.supensosAsignatura(1));
		System.out.println(primero.MediaAlumno(1));
		System.out.println(primero.MediaAsignatura(1));
		primero.MostrarBoletinClase();
		System.out.println(" ");
		System.out.println(" ");
		primero.MostrarBoletinAlumno(1);
		primero.MostrarResumenAsignatura(1);
                // Comentario añadido por Daniel Mera
                // Comentario 2 añadido por Daniel Mera
                //Comentario 3 añadido por Daniel Mera
                
                System.out.println("Prueba de commit 2");
                System.out.println("Prueba commit 3");
                System.out.println("Prueba commit 4");
                System.out.println("Prueba commit Daniel Mera");
                System.out.println("Commit final por David Ramos");
	}
}
