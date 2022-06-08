import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class JAXBParser {
    public static void main(String[] args) {
        String schemaPath = ".\\src\\main\\resources\\xml\\chat.xsd";
        String xmlPath = ".\\src\\main\\resources\\xml\\chat.xml";

        try {
            SchemaValidator.schemaValidator(schemaPath, xmlPath);

            File file = new File("./src/main/resources/xml/chat.xml");

            JAXBContext context = JAXBContext.newInstance(Root.class, Users.class, User.class);
            Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();

            Root usersJAXB = (Root) jaxbUnmarshaller.unmarshal(file);

            usersJAXB.getUsers().getUsers().get(0).setCountry("NotRussia"); // Changing default values
            usersJAXB.getUsers().getUsers().get(0).setFullname("AnotherName");

            System.out.println(usersJAXB.getUsers().getUsers()); // output for tests

            // generating and writing html
            HTMLGenerator generator = new HTMLGenerator();
            Writer output = generator.generateHTML(usersJAXB.getUsers());
            generator.createHTML(output);
            System.out.println(output);

            Marshaller jaxbMarshaller = context.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "src/main/resources/xml/chat.xsd");

            OutputStream os = new FileOutputStream("./src/main/resources/xml/newXML.xml");

            jaxbMarshaller.marshal(usersJAXB, os);
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("JAXBException occurred: " + e.getMessage());
        } catch (XMLStreamException e) {
            e.printStackTrace();
            System.out.println("XMLStreamException occurred: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException occurred: " + e.getMessage());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            System.out.println("InvocationTargetException occurred: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException occurred: " + e.getMessage());
        }
    }
}
