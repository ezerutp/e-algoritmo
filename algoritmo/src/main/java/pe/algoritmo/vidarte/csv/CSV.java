package pe.algoritmo.vidarte.csv;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import pe.algoritmo.vidarte.interfaces.CSVUtil;
import pe.algoritmo.vidarte.utils.Lista;

public class CSV<T extends CSVUtil> {

    private static final String CSV_DELIMITER = ",";
    private Class<T> clazz;
    private String fileString;

    // constructor
    public CSV(Class<T> clazz) {
        try {
            this.clazz = clazz;
            T instancia = clazz.getDeclaredConstructor().newInstance();
            this.fileString = instancia.getFilePath();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee los registros del archivo CSV.
     * 
     * @param filePath La ruta del archivo CSV.
     * @return Una lista de registros leídos.
     */
    private Lista<String[]> leerRegistros(String filePath) {
        Lista<String[]> registros = new Lista<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                registros.agregarAlFinal(linea.split(CSV_DELIMITER));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return registros;
    }

    /**
     * Obtiene el identificador máximo de los registros leídos del CSV.
     * 
     * @return El identificador máximo encontrado.
     */
    public int obtenerIdMaximo() {
        Lista<T> objetos = leerCSV();
        int maxId = 0;
        for (T objeto : objetos) {
            if (objeto.getId() > maxId) {
                maxId = objeto.getId();
            }
        }
        return maxId;
    }

    /**
     * Lee los registros del archivo CSV y los convierte en una lista de objetos.
     * 
     * @return Una lista de objetos leídos del archivo CSV.
     */
    public Lista<T> leerCSV() {
        Lista<T> objetos = new Lista<>();
        try {

            Lista<String[]> registros = leerRegistros(fileString);

            for (String[] registro : registros) {
                T objeto = this.clazz.getDeclaredConstructor().newInstance();
                // unimos el csv para crear los objetos
                objeto.fromCSV(String.join(CSV_DELIMITER, registro));
                objetos.agregarAlFinal(objeto);
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    /**
     * Busca y devuelve un objeto específico por su identificador.
     * 
     * @param id El identificador del objeto a buscar.
     * @return El objeto encontrado si existe, de lo contrario devuelve null.
     */
    public T leerPorId(int id) {
        try {
            T instancia = this.clazz.getDeclaredConstructor().newInstance();
            Lista<String[]> registros = leerRegistros(fileString);

            for (String[] registro : registros) {
                instancia.fromCSV(String.join(",", registro));
                if (instancia.getId() == id) {
                    return instancia;
                }
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Registra un nuevo objeto en el archivo CSV.
     * 
     * @param objeto El objeto a registrar.
     * @return Verdadero si el registro es exitoso, de lo contrario devuelve falso.
     */
    public boolean registrar(T objeto) {

        try (FileWriter fw = new FileWriter(objeto.getFilePath(), true);
                BufferedWriter bw = new BufferedWriter(fw)) {

            String nuevaLinea = objeto.toCSV();
            bw.write(nuevaLinea);
            bw.newLine(); // Agregar una nueva línea si es necesario
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * Elimina un objeto específico por su identificador del archivo CSV.
     * 
     * @param id El identificador del objeto a eliminar.
     * @return Verdadero si el objeto es eliminado con éxito, de lo contrario devuelve falso.
     */
    public boolean eliminarPorId(int id) {
        try {
            T instancia = this.clazz.getDeclaredConstructor().newInstance();
            Lista<String[]> registros = leerRegistros(fileString);
            Lista<String[]> nuevosRegistros = new Lista<>();

            boolean encontrado = false;

            for (String[] registro : registros) {
                instancia.fromCSV(String.join(",", registro));
                if (instancia.getId() == id) {
                    encontrado = true;
                } else {
                    nuevosRegistros.agregarAlFinal(registro);
                }
            }

            if (encontrado) {
                // Actualizar el archivo CSV con los registros restantes
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(instancia.getFilePath()))) {
                    for (String[] nuevoRegistro : nuevosRegistros) {
                        bw.write(String.join(",", nuevoRegistro));
                        bw.newLine();
                    }
                }
                return true;
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException
                | IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Actualiza un objeto específico por su identificador en el archivo CSV.
     * 
     * @param id El identificador del objeto a actualizar.
     * @param nuevoObjeto El nuevo objeto que reemplazará al objeto existente.
     * @return Verdadero si el objeto es actualizado con éxito, de lo contrario devuelve falso.
     */
    public boolean actualizarPorId(int id, T nuevoObjeto) {
        try {
            T instancia = this.clazz.getDeclaredConstructor().newInstance();
            Lista<String[]> registros = leerRegistros(fileString);
            Lista<String[]> nuevosRegistros = new Lista<>();

            boolean encontrado = false;

            for (String[] registro : registros) {
                instancia.fromCSV(String.join(",", registro));
                if (instancia.getId() == id) {
                    // Reemplazar el objeto existente con el nuevo objeto
                    nuevosRegistros.agregarAlFinal(nuevoObjeto.toCSV().split(",")); // Agregar el nuevo registro
                    encontrado = true;
                } else {
                    nuevosRegistros.agregarAlFinal(registro); // Mantener el registro existente sin cambios
                }
            }

            if (encontrado) {
                // Actualizar el archivo CSV con los registros actualizados
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(instancia.getFilePath()))) {
                    for (String[] nuevoRegistro : nuevosRegistros) {
                        bw.write(String.join(",", nuevoRegistro));
                        bw.newLine();
                    }
                }
                return true;
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException
                | IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}