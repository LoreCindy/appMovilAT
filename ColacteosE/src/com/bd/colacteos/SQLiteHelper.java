package com.bd.colacteos;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class SQLiteHelper extends SQLiteOpenHelper {

//----------------------------------------------
//nombre de la base de datos
//----------------------------------------------
private static final String bd = "colacteos";
//--------------------------------------------
//versión de la base de datos
//--------------------------------------------
private static final int version =16;
//-------------------------------------------
// tabla usuario y campos de tabla de usuario
//-------------------------------------------
public final static String tabla_usuario = "tabla_usuario";
public final String id_usuario="id_usuario";
public final String nombres = "nombres";
public final String apellidos="apellidos";
public final String usuario= "usuario";
public final String password = "password";


//---------------------------------------------------------
//sentencia  para crear tablas usuario
//----------------------------------------22------------------
	
String sql = "CREATE TABLE tabla_usuario( id_usuario INTEGER PRIMARY KEY UNIQUE, nombres VARCHAR, apellidos VARCHAR, usuario VARCHAR, password VARCHAR)";


//-------------------------------------------
// campos de tabla de profesional
//-------------------------------------------
public final static String SAT_profesional= "SAT_profesional";
public final String Nit= "Nit";
public final String  Nombres= "Nombres";
public final String Apellidos="Apellidos";
public final String  Titulo= "Titulo";
public final String  Institucion= "Institucion";

//----------------------------------------------------------------
//sentencia para crear la tabla SAT profesional
//-----------------------------------------------------------------
String sql1= "CREATE TABLE SAT_profesional (Nit INTEGER PRIMARY KEY UNIQUE," +
		" Nombres VARCHAR, Apellidos VARCHAR, Titulo VARCHAR, Institucion VARCHAR)";


//-------------------------------------------
// campos de tabla de UGG_informacion
//-------------------------------------------
public final static String UGG_informacion="UGG_informacion";
public final String codigo_UGG= "codigo_UGG";
public final String  nombre_UGG= " nombre_UGG";
public final String fecha_nacimiento="fecha_nacimiento";
public final String  peso_UGG= "peso_UGG";
public final String  numero_partos= "numero_partos";
public final String  raza_UGG= "raza_UGG";
public final String  fecha_venta= "fecha_venta";
public final String  fecha_muerte= "fecha_muerte ";
public final String  motivo_muerte= "motivo_muerte";
public final String  genero= "genero";
public final String  cantidad_abortos= "cantidad_abortos";
public final String  servicio_toro= "servicio_toro";
//public final String  codi_finca= "codi_finca";
public final String  tipo_animal= "tipo_animal";

//----------------------------------------------------------------
//sentencia para crear la tabla UGG informacion animal
//----------------------------------------------------------------- 
String ugg=" CREATE TABLE UGG_informacion (codigo_UGG SMALLINT PRIMARY KEY UNIQUE," +
		" nombre_UGG VARCHAR, fecha_nacimiento DATE, peso_UGG INTEGER," +
		"  raza_UGG VARCHAR, fecha_venta DATE," +
		" fecha_muerte DATE,motivo_muerte VARCHAR, genero VARCHAR,  " +
		"codigo_finca SMALLINT REFERENCES SAT_terceros_fincas (codigo_finca)," +
		"cantidad_abortos SMALLINT, servicio_toro SMALLINT,tipo_animal VARCHAR,  numero_partos SMALLINT )";
//


//-------------------------------------------
//campos de tabla de SAT Terceros fincas
//-------------------------------------------
public final static String SAT_terceros_fincas ="SAT_terceros_fincas";
public final String codigo_finca= "codigo_finca";
public final String  nombre_finca= "nombre_finca";
public final String nit_propietario="nit_propietario";
public final String  ciudad= "ciudad";
public final String ubicacion= "ubicacion";
public final String  hectareas= "hectareas";
public final String  latitud= "latitud";
public final String  longitud= "longitud";
public final String  mano_obra= "mano_obra";
public final String  codigo_tipo_ordeno= "codigo_tipo_ordeno";
public final String  departamento= "departamento";

//----------------------------------------------------------------
//sentencia para crear la tabla SAT fincas
//----------------------------------------------------------------- 
String finca="CREATE TABLE SAT_terceros_fincas (codigo_finca SMALLINT PRIMARY KEY UNIQUE, " +
		"nombre_finca VARCHAR, " +
		"nit_propietario FLOAT REFERENCES SAT_terceros_asociados (nit)," +
		"ciudad VARCHAR, ubicacion VARCHAR, " +
		"hectareas FLOAT, latitud SMALLINT, longitud SMALLINT, " +
		"mano_obra VARCHAR,  codigo_tipo_ordeno VARCHAR,  departamento VARCHAR)";



//-------------------------------------------
//campos de tabla de SAT finca cultivo
//-------------------------------------------
public final static String SAT_finca_cultivo ="SAT_finca_cultivo";
public final String codig_finca= "codig_finca";
public final String  codigo_cultivo= "codigo_cultivo";


//----------------------------------------------------------------
//sentecia para crear la tabla finca_cultivo
//----------------------------------------------------------------
String Finca_cultivo="CREATE TABLE SAT_finca_cultivo (codig_cutivo SMALLINT REFERENCES SAT_cultivo (cod_cultivo), codig_finca SMALLINT REFERENCES SAT_terceros_fincas (codigo_finca))";


//-----------------------------------------------------------
//campos de tabla de SAT cultivo
//-------------------------------------------------------------

public final static String SAT_cultivo ="SAT cultivo";
public final String cod_cultivo="cod_cultivo";
public final String nom_cultivo= "nom_cultivo";
public final String promedio_hectarea= "promedio_hectarea";
public final String codigo_fincas="codigo_fincas";


//----------------------------------------------------------------
//sentecia para crear la tabla cultivo
//----------------------------------------------------------------
String cultivo="CREATE TABLE SAT_cultivo(cod_cultivo SMALLINT PRIMARY KEY UNIQUE," +
		"nom_cultivo VARCHAR, promedio_hectaria FLOAT, codigo_fincas SMALLINT REFERENCES SAT_finca_cultivo (codig_finca))";


//-----------------------------------------------------------
//campos de tabla de SAT asociado
//-------------------------------------------------------------

public final static String SAT_terceros_asociados ="asociados";
public final String nit_asociado="nit_asociado";
public final String cod_finca= "cod_finca";
public final String nombre_Completo= "nombre_completo";
public final String Direccion= "Direccion";
public final String telefono= "telefono";
public final String Tipo_identificacion="tipo_identificacion";

//----------------------------------------------------------------
//sentecia para crear la tabla asociado
//----------------------------------------------------------------
String asociado= "CREATE TABLE SAT_terceros_asociados (nit_asociado FLOAT PRIMARY KEY NOT NULL UNIQUE," +
		" cod_finca SMALLINT REFERENCES SAT_terceros_fincas (codigo_finca), nombre_Completo VARCHAR NOT NULL, " +
		"Direccion  VARCHAR NOT NULL, telefono VARCHAR NOT NULL" +
		", Tipo_identificacion VARCHAR NOT NULL)";



//-----------------------------------------------------------
//campos de tabla de Sat sistema
//-------------------------------------------------------------
public final static String SAT_sistema="SAT_sistema";
public final String cod_sistema= "cod_sistema";
public final String nom_sistema= "nom_sistema";

String Sat_sistema="CREATE TABLE SAT_sistema(cod_sistema SMALLINT PRIMARY KEY UNIQUE, nom_sistema VARCHAR)";

//-----------------------------------------------------------
//campos de tabla de Sat CASUISTICA
//-------------------------------------------------------------
public final  static String SAT_casuistica="SAT_casuistica";
public final String cod_casuistica = "cod_casuistica";
public final String enfermedad= "enfermedad";

String Sat_casuistica="CREATE TABLE SAT_casuistica (cod_casuistica SMALLINT PRIMARY KEY, enfermedad VARCHAR, cod_sistema SMALLINT REFERENCES SAT_sistema (cod_sistema))";

//-----------------------------------------------------------
//campos de tabla de forraje
//-------------------------------------------------------------
public final static String SAT_forraje="SAT_forraje";
public final String codigo_forraje= "codigo_forraje";
public final String nombre_forraje = "nombre_forraje";


String forraje= "CREATE TABLE SAT_forraje (codigo_forraje SMALLINT PRIMARY KEY UNIQUE, nombre_forraje VARCHAR)";



//-----------------------------------------------------------
//campos de tabla de produccion
//-------------------------------------------------------------
public final static String UGG_produccion ="UGG_produccion";
public final String cod_produccion="cod_produccion";
public final String fecha_produccion= "fecha_produccion";
public final String litros_produccion= "litros_produccion";
public final String codigo_animal = "codigo_animal";

//----------------------------------------------------------------
//sentecia para crear la tabla ugg produccion
//------------------------------------------------------------------

String UGG_producciones=" CREATE TABLE UGG_produccion (cod_produccion SMALLINT PRIMARY KEY NOT NULL UNIQUE, " +
		"fecha_produccion DATE NOT NULL, litros_produccion SMALLINT NOT NULL, codigo_animal SMALLINT REFERENCES UGG_informacion (codigo_UGG))";

//-----------------------------------------------------------
//campos de tabla de SAT visita
//-------------------------------------------------------------
public final static String SAT_visita ="SAT_visita";
public final String id_visita="id_visita";
public final String cod_fincas= "cod_fincas";
public final String fecha_visita= "fecha_visita";
public final String hora_ingreso  = "hora_ingreso";
public final String clase_visita ="clase_visita";
public final String cumple="cumple";
public final String num_recetario=" num_recetario";
public final String nit_profesional="nit_profesional";
public final String tipo_visita="tipo_visita";
public final String observaciones="observaciones";
public final String identificacion_asociado="identificacion_asociado";


//---------------------------------------------------------------
//campos de la tabla visita casuistica animal
//-------------------------------------------------------------

public final static String visita_casuistica_animal ="visita_casuistica_animal";
public final String casuistica="casuistica";
public final String UGG= "UGG";
public final String visita_id= "visita_id";

//----------------------------------------------------------------
// sentencia de la tabla visita_casuistica_animal
//---------------------------------------------------------------

String tablaViCaAn ="CREATE TABLE visita_casuistica_animal (casuistica SMALLINT REFERENCES SAT_casuistica (cod_casuistica), " +
		"UGG SMALLINT REFERENCES UGG_informacion (codigo_UGG)," +
		"visita_id SMALLINT REFERENCES SAT_visita (id_visita))";

//----------------------------------------------------------------
//sentecia para crear la tabla SAT visita
//------------------------------------------------------------------
String visita="CREATE TABLE SAT_visita (id_visita SMALLINT PRIMARY KEY NOT NULL UNIQUE," +
		" cod_fincas SMALLINT REFERENCES SAT_terceros_fincas (codigo_finca)," +
		"fecha_visita DATE NOT NULL, hora_ingreso TIME NOT NULL, " +
		"clase_visita VARCHAR NOT NULL , " +
		"cumple VARCHAR NOT NULL, num_recetario INTEGER NOT NULL," +
		"nit_profesional FLOAT REFERENCES SAT_profesional (Nit)," +
		"tipo_visita SMALLINT REFERENCES SAT_tipo_visita (codigo_tipo_visita)," +
		" observaciones TEXT , identificacion_asociado FLOAT REFERENCES SAT_terceros_asociados (nit))";
//CHECK (([clase_Visita]='A' OR [clase_Visita]='Z' OR [clase_Visita]='V'))

//-----------------------------------------------------------
//campos de tabla de SAT tipo visita
//-------------------------------------------------------------
public final static String SAT_tipo_visita ="SAT_tipo_visita";
public final String codigo_tipo_visita ="codigo_tipo_visita";
public final String nombre_tipo_visita= "nombre_tipo_visita";


//----------------------------------------------------------------
//sentecia para crear la tabla SAT tipo visita
//------------------------------------------------------------------  
	 
	String tipoVisita= "CREATE TABLE SAT_tipo_visita (codigo_tipo_visita SMALLINT PRIMARY KEY NOT NULL UNIQUE, " +
			"nombre_tipo_visita VARCHAR NOT NULL)";
	

	//-----------------------------------------------------------
	//campos de tabla de SAT tipo tipo labor
	//-------------------------------------------------------------
	public final static String SAT_tipo_labor ="SAT_tipo_labor";
	public final String codigo_labor ="codigo_labor";
	public final String nombre_labor= "nombre_labor";
	public final String valor_labor= "valor_labor";
	
	//----------------------------------------------------------------
	//sentecia para crear la tabla SAT tipo labor
	//------------------------------------------------------------------
	String tipoLabor ="CREATE TABLE SAT_tipo_labor (codigo_labor SMALLINT PRIMARY KEY NOT NULL UNIQUE, " +
			"nombre_labor VARCHAR NOT NULL, valor_labor BINARY NOT NULL)";

	
					
			
			//-----------------------------------------------------------
			//campos de tabla de SAT actividad
			//-------------------------------------------------------------
			public final static String SAT_actividad="SAT_actividad";
			public final String id_actividad="id_actividad" ;
			public final String  nom_actividad ="nom_actividad";
			public final String  costo_actividad ="costo_actividad";
			//----------------------------------------------------------------
			//sentecia para crear la tabla SAT actividad
			//------------------------------------------------------------------
				
			 String actividad= "CREATE TABLE SAT_actividad (id_actividad SMALLINT PRIMARY KEY NOT NULL UNIQUE," +
					" nom_actividad VARCHAR NOT NULL, costo_actividad  SMALLINT  )";
			
			
			 
			//-----------------------------------------------------------
				//campos de tabla de visita actividad Animal
				//-------------------------------------------------------------
				public final static String visita_actividad_animal="visita_actividad_animal";
				public final String identificacion_actividad ="identificacion_actividad" ;
				public final String  codig_UGG  ="codig_UGG";
				public final String id_visitas="id_visitas";
				public final String id_visita_anterior="id_visita_anterior";
				public final String observacion="observacion";
			//----------------------------------------------------------------
			//sentecia para crear la tabla VISITA actividad animal
			//------------------------------------------------------------------
						
			String visitaActiAnimal="CREATE TABLE visita_actividad_animal (identificacion_actividad SMALLINT PRIMARY KEY," +
					" codig_UGG SMALLINT REFERENCES UGG_informacion (codigo_UGG)," +
					" id_visitas SMALLINT REFERENCES SAT_visita (id_visita), id_visita_anterior INTEGER," +
					"observacion TEXT)";
			
			
			
			
			//-----------------------------------------------------------
			//campos de tabla sat zootecnia
			//-------------------------------------------------------------
			public final static String SAT_Zootecnia="SAT_Zootecnia";
			public final String visita_ID ="visita_ID" ;
			public final String  capacidad_UGG  ="capacidad_UGG";
			public final String aforo_Kilogramos="aforo_Kilogramos";
			public final String forraje_ID="forraje_ID";
			
			//----------------------------------------------------------------
			//sentecia para crear la tabla sat zootecnia
			//------------------------------------------------------------------
		 String Zootecnia="CREATE TABLE SAT_Zootecnia (visita_ID SMALLINT REFERENCES SAT_visita (id_visita), capacidad_UGG SMALLINT, aforo_Kilogramos INTEGER,forraje_ID SMALLINT REFERENCES SAT_forraje (codigo_forraje))";
		
		 
		   //-----------------------------------------------------------
			//campos de tabla sat veterninaria
			//-------------------------------------------------------------
			public final static String SAT_Veterinaria="SAT_Veterinaria";
			public final String codigoAnimal =" codigoAnimal" ;
			public final String  identificacion_visita="identificacion_visita";
		   //----------------------------------------------------------------
			//sentecia para crear la tabla sat veterinaria
			//------------------------------------------------------------------
		    String veterinaria="CREATE TABLE SAT_Veterinaria (codigoAnimal SMALLINT REFERENCES UGG_informacion (codigo_UGG), " +
		    		"identificacion_visita SMALLINT REFERENCES SAT_visita(id_visita))";
			
		    
		  //-----------------------------------------------------------
			//campos de tabla sat agronomia
			//-------------------------------------------------------------
	/*	public final static String SAT_Agronomia="SAT_Agronomia";
			public final String columnaID_vista ="columnaID_vista";
			public final String area ="area" ;
			public final String aforo_kilogramos="aforo_kilogramos";
			public final String dias_rotacion="dias_rotacion" ;
			public final String  capacidad_animal=" capacidad_animal";
			public final String  dias_ocupacion="dias_ocupacion";
			public final String codigo_labores="codigo_labores" ;
			public final String codigo_Cultivos ="codigo_Cultivos ";
			public final String produccion_leche="produccion_leche";
			public final String costo_cultivo_kg ="costo_cultivo_kg";
			
		    //----------------------------------------------------------------
			//sentecia para crear la tabla sat agronomia
			//------------------------------------------------------------------
					
			  String agron="CREATE TABLE SAT_Agronomia (columnaID_vista SMALLINT REFERENCES SAT_visita (id_visita), " +
			  		"area VARCHAR, " +
			  		"aforo_kilogramos SMALLINT, " +
			  		"dias_rotacion SMALLINT, " +
			  		"capacidad_animal SMALLINT, dias_ocupacion SMALLINT," +
			  		" codigo_labores SMALLINT REFERENCES SAT_tipo_labor (codigo_labor)," +
			  		" codigo_Cultivos SMALLINT REFERENCES SAT_cultivo (cod_cultivo), " +
			  		"produccion_leche SMALLINT, costo_cultivo_kg SMALLINT))";
		   
			
				*/
//----------------------------------------------------------------------
//constructor
//------------------------------------------------------------------------
	public SQLiteHelper(Context contexto) {
		super(contexto,bd, null, version);
		
	}
	
//----------------------------------------------------------------------
//creacion de la bd
//------------------------------------------------------------------------

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sql);
		db.execSQL(sql1);
		db.execSQL(ugg);
		db.execSQL(finca);
		//Insertar un registro
		db.execSQL("INSERT INTO SAT_terceros_fincas (codigo_finca, nombre_finca, nit_propietario, ciudad, ubicacion, hectareas, latitud, longitud, mano_obra, codigo_tipo_ordeno, departamento) VALUES ('2','villadocente','12345', 'ipiales','las lajas', '23','10','21','contratada','mecanico','Nariño' ) ");

		//db.execSQL("INSERT INTO SAT_terceros_asociados (nit_asociado,cod_finca,nombre_Completo, Direccion, telefono, Tipo_identificacion )VALUES ('12345','2', 'pepito Perez','chachagui', '3153432345', 'Cedula ciudadania' ) ");
		 

		
		
		db.execSQL(cultivo);
		db.execSQL(asociado);
		db.execSQL(forraje);
		db.execSQL(Sat_sistema);
		db.execSQL(Sat_casuistica);
		db.execSQL(Finca_cultivo);
		db.execSQL(UGG_producciones);
		
		db.execSQL(visita);
		db.execSQL(tipoVisita);
		db.execSQL(tipoLabor);
		db.execSQL(actividad);
		db.execSQL(visitaActiAnimal);
		db.execSQL(tablaViCaAn);
		db.execSQL(	Zootecnia);
		db.execSQL(veterinaria);
		//db.execSQL(agron);
		//---------------------------------

		
/*db.execSQL(visita);
		
		
		db.execSQL(tipoForraje);
		db.execSQL(sistema);
		db.execSQL(costoActividad);
		db.execSQL(costo);
		db.execSQL(casuistica);
		
		db.execSQL(visitaActiAnimal);
		db.execSQL(casuisticaAnimal);
		db.execSQL(Zootecnia);
		

		
	
		*/
	}
//-----------------------------------------------------------------------
// permite actualizar la base de datos
//-----------------------------------------------------------------------
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		if ( newVersion > oldVersion )
		{
			//---------------------------------------------
			//elimina tabla
			//----------------------------------------------
			db.execSQL( "DROP TABLE IF EXISTS tabla_usuario ");
			db.execSQL( "DROP TABLE IF EXISTS SAT_profesional ");
			db.execSQL( "DROP TABLE IF EXISTS UGG_informacion ");
			
			db.execSQL( "DROP TABLE IF EXISTS SAT_terceros_fincas ");
		
			db.execSQL( "DROP TABLE IF EXISTS SAT_forraje ");
			
			db.execSQL( "DROP TABLE IF EXISTS y_departamento ");
			db.execSQL( "DROP TABLE IF EXISTS UGG_tipo_ordeño  ");
			db.execSQL( "DROP TABLE IF EXISTS SAT_cultivo ");
			
			db.execSQL( "DROP TABLE IF EXISTS SAT_terceros_asociados");
			db.execSQL( "DROP TABLE IF EXISTS tipo_animal");
					
			db.execSQL( "DROP TABLE IF EXISTS UGG_produccion  ");
			db.execSQL( "DROP TABLE IF EXISTS SAT_visita  ");
			db.execSQL( "DROP TABLE IF EXISTS SAT_tipo_visita");
			
			db.execSQL( "DROP TABLE IF EXISTS SAT_tipo_labor ");
			db.execSQL( "DROP TABLE IF EXISTS SAT_tipo_forraje ");
			db.execSQL( "DROP TABLE IF EXISTS SAT_sistema ");
			
			db.execSQL( "DROP TABLE IF EXISTS SAT_costo_actividad");
			db.execSQL( "DROP TABLE IF EXISTS SAT_costo ");
			db.execSQL( "DROP TABLE IF EXISTS SAT_casuistica");
			
			db.execSQL( "DROP TABLE IF EXISTS SAT_actividad  ");
			db.execSQL( "DROP TABLE IF EXISTS visita_actividad_animal");
			db.execSQL( "DROP TABLE IF EXISTS visita_casuistica_animal");
			
			db.execSQL( "DROP TABLE IF EXISTS SAT_Zootecnia ");
			db.execSQL( "DROP TABLE IF EXISTS SAT_Veterinaria");
			db.execSQL( "DROP TABLE IF EXISTS SAT_Agronomia ");
			db.execSQL( "DROP TABLE IF EXISTS SAT_finca_cultivo ");
			
			
			//--------------------------------------------
			// creamos la nueva tabla
			//-------------------------------------------
	//onCreate(db);
			db.execSQL(sql);
			db.execSQL(sql1);
			db.execSQL(ugg);
			db.execSQL(finca);
			
			db.execSQL(cultivo);
			db.execSQL(asociado);
			db.execSQL(forraje);
			db.execSQL(Sat_sistema);
			db.execSQL(Sat_casuistica);
			db.execSQL("Finca_cultivo");
			db.execSQL(UGG_producciones);
			db.execSQL(visita);
			db.execSQL(tipoVisita);
			db.execSQL(tipoLabor);
			db.execSQL(actividad);
			db.execSQL(visitaActiAnimal);
			db.execSQL(tablaViCaAn);
			db.execSQL(Zootecnia);
			db.execSQL(veterinaria);
			//db.execSQL(agron);
			//-----------------------------------------
			/*
			
			
			
			db.execSQL(costoActividad);
			db.execSQL(costo);
	
			
			db.execSQL(casuisticaAnimal);
			
			
		
			*/
		}
		
		
		 
	}

	
	

}
