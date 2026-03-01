# Conversor de Monedas

Aplicación de consola para convertir monedas en tiempo real utilizando la API de [ExchangeRate-API](https://www.exchangerate-api.com/). El programa permite realizar conversiones entre diferentes monedas y mantiene un historial de las operaciones realizadas.

## Características

- 🔄 Conversión en tiempo real entre múltiples monedas
- 📊 Historial de conversiones realizadas durante la sesión
- 💾 Generación automática de archivo JSON con el registro de conversiones
- 🖥️ Interfaz de usuario simple e intuitiva por consola

## Monedas Soportadas

- USD (Dólar estadounidense)
- ARS (Peso argentino)
- BRL (Real brasileño)
- COP (Peso colombiano)

## Operaciones Disponibles

1. USD → ARS
2. ARS → USD
3. USD → BRL
4. BRL → USD
5. USD → COP
6. COP → USD
7. Salir

## Requisitos Previos

- Java JDK 11 o superior
- Conexión a Internet (para consultar la API)
- Dependencia Gson para manejo de JSON

## Instalación

1. Clona este repositorio:
```bash
git clone https://github.com/tu-usuario/conversor-monedas.git
```

2. Asegúrate de tener la librería Gson en tu classpath. Si usas Maven, agrega la dependencia:
```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
```

## Uso

1. Ejecuta la clase `Principal`:
```bash
javac Principal.java
java Principal
```

2. Sigue las instrucciones en pantalla:
   - Selecciona el tipo de conversión (1-6)
   - Ingresa el monto a convertir
   - Visualiza el resultado
   - El programa continuará hasta que selecciones la opción 7 para salir

3. Al salir, se mostrará un resumen de todas las operaciones realizadas

## Estructura del Proyecto

- **`Principal.java`**: Clase principal con el menú interactivo y lógica de negocio
- **`ConsultaAPI.java`**: Maneja las solicitudes HTTP a la API externa
- **`Conversion.java`**: Record que representa la estructura de datos de la respuesta API
- **`GeneradorDeArchivo.java`**: Genera archivo JSON con el historial de conversiones

## Archivos Generados

El programa genera automáticamente un archivo `conversion.json` que contiene el historial completo de conversiones realizadas durante la sesión, con el siguiente formato:

```json
[
  {
    "result": "success",
    "base_code": "USD",
    "target_code": "ARS",
    "conversion_rate": 850.50,
    "conversion_result": 4252.50,
    ...
  }
]
```

## API Utilizada

Este proyecto utiliza [ExchangeRate-API](https://www.exchangerate-api.com/):
- Endpoint: `https://v6.exchangerate-api.com/v6/{API_KEY}/pair/{base}/{target}/{amount}`
- La API key incluida es de prueba; se recomienda obtener una propia desde su sitio web

## Ejemplo de Uso

```
= = = = = = = = = = = = = = =
Bienvenido al Conversor de Monedas
1) USD a ARS
2) ARS a USD
3) USD a R$
4) R$ a USD
5) USD a COP
6) COP a USD
7) - SALIR
= = = = = = = = = = = = = = =
1
Ingrese la cantidad: 
100
El valor ingresado: [ 100.0 USD ] corresponde a 85000.0 ARS
```

## Contribuciones

Las contribuciones son bienvenidas. Por favor:
1. Haz fork del proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## Contacto

Tu Nombre - [@tutwitter](https://twitter.com/tutwitter)

Link del proyecto: [https://github.com/tu-usuario/conversor-monedas](https://github.com/tu-usuario/conversor-monedas)
