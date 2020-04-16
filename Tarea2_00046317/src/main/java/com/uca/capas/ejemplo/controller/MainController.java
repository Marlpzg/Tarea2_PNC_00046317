package com.uca.capas.ejemplo.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/ejemplo")
	public @ResponseBody String ejemplo() {
		
		String texto = "Hola Mundo desde Spring MVC! La hora actual es: ";
		return texto.concat(Calendar.getInstance().getTime().toString());
		
	}
	
	@RequestMapping("/parametro")
	public @ResponseBody String parametro(HttpServletRequest request) {
		
		Integer param = Integer.parseInt(request.getParameter("dia"));
		String dia;
		
		switch(param) {
			case 1: dia = "Lunes";
			break;
			case 2: dia = "Martes";
			break;
			case 3: dia = "Miercoles";
			break;
			case 4: dia = "Jueves";
			break;
			case 5: dia = "Viernes";
			break;
			case 6: dia = "Sabado";
			break;
			case 7: dia = "Domingo";
			break;
			default: dia = "Ningun dia seleccionado";
			break;
		}
		
		return "Dia de la semana enviado: " + dia;
		
	}
	
	@RequestMapping("/alumno")
	public @ResponseBody String alumno() {
		
		String texto = "Nombre: Mario Isaac López Guevara<br>Carné: 00046317<br>Carrera: Ingeniería Informática<br>Año en curso: Cuarto";
		return texto;
		
	}
	
	@RequestMapping("/fecha")
	public @ResponseBody String fecha(HttpServletRequest request) {
		
		Integer date = Integer.parseInt(request.getParameter("d"));
		Integer month = Integer.parseInt(request.getParameter("m"))-1;
		Integer year = Integer.parseInt(request.getParameter("a"));
		
		Calendar c = Calendar.getInstance();
		c.setLenient(false);
		String dia = null;
		try {
			c.set(year, month, date);
			switch(c.get(Calendar.DAY_OF_WEEK)) {
			
				case 2: dia = "Lunes";
				break;
				case 3: dia = "Martes";
				break;
				case 4: dia = "Miercoles";
				break;
				case 5: dia = "Jueves";
				break;
				case 6: dia = "Viernes";
				break;
				case 7: dia = "Sabado";
				break;
				case 1: dia = "Domingo";
				break;
			}
		}catch(IllegalArgumentException e) {
			dia = "Ningun dia seleccionado";
		}
		
		return "Dia de la semana especificado: " + dia;
		
	}

}
