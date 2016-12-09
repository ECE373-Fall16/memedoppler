package com.example.chad.memedoppler;

/*import java.io.StringReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPFaultException;
import org.json.JSONObject;
import org.json.XML;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import static org.junit.Assert.assertTrue;//*/

public class WSClient {
    /*public static void main (String[] args) {
        WSClient wsc = new WSClient();

        // get forecast by Zip Code
        wsc.getWeatherForecast("01003"); // Amherst

    }

    public void getWeatherForecast(String zipCode) {

        JSONObject obj = null;

        try {
            // Convert the ZIP code to a geocoded value (which is needed
            // as input for the weather data)

            String nsSchema = "http://graphical.weather.gov/xml/DWMLgen/schema/DWML.xsd";

            String soapSchema = "http://schemas.xmlsoap.org/soap/envelope/";

            String xsiSchema
                    = "http://www.w3.org/2001/XMLSchema-instance";

            String encodingStyle
                    = "http://schemas.xmlsoap.org/soap/encoding/";

            String zipRequest = "<S:Envelope "
                    + " xmlns:S=\"" + soapSchema + "\" "
                    + " xmlns:xsi=\"" + xsiSchema + "\" "
                    + " xmlns:schNS=\"" + nsSchema + "\"> "
                    + "<S:Body>"
                    +"   <LatLonListZipCode S:encodingStyle=\""
                    +           encodingStyle + "\">"
                    +           "<schNS:zipCodeList xsi:type=\"schNS:zipCodeListType\">"
                    +               zipCode
                    +           "</schNS:zipCodeList>"
                    +    "</LatLonListZipCode>"
                    +"</S:Body>"
                    +"</S:Envelope>";

            String wsdl = "http://graphical.weather.gov/xml/SOAP_server/ndfdXMLserver.php?wsdl";
            String targetNS = "http://graphical.weather.gov/xml/DWMLgen/wsdl/ndfdXML.wsdl";

            URL url = new URL(wsdl);
            QName serviceName = new QName(targetNS, "ndfdXML");
            QName portName = new QName(targetNS, "ndfdXMLPort");
            Service service = Service.create(url, serviceName);

            /*
             * JAX-WS Dispatch provides three usage options: -- JAXBContext
             * (unsure if works though for rpc/enc WSDL) -- JAXP Source objects
             * (used here) -- SAAJ SOAPMessages (used in 2nd request below)
             */
            /*Dispatch<Source> dispatch = service.createDispatch(portName,
                    Source.class, Service.Mode.MESSAGE);
            Source zipResponse = dispatch.invoke(
                    new StreamSource(new StringReader(zipRequest)));
            // if using a file for input instead:
            // new StreamSource(new File("myrequest.xml")));

            // use SAAJ to open message -- check if error or valid data
            MessageFactory msgFactory = MessageFactory.newInstance();
            SOAPMessage geocodeMsg = msgFactory.createMessage();
            SOAPPart env = geocodeMsg.getSOAPPart();
            env.setContent(zipResponse);
            // writeTo method outputs SOAPMessage, helpful for debugging
            //geocodeMsg.writeTo(System.out);


            if (geocodeMsg.getSOAPBody().hasFault()) {
                // Copy official error response into our LNF Fault
                SOAPFault fault = geocodeMsg.getSOAPBody().getFault();
                System.out.println("Could not obtain forecast for zipcode "
                        + zipCode + ": "
                        + fault.getFaultString() + "; " + fault.getDetail().getValue());
            }

            // From here: valid geocode is present-- so get weather report next

            /*
             * LatLonListZipCodeResponse is not very helpful; needed information
             * (latLonList) element is html-escaped instead of a real tag, which
             * is suitable for HTML responses but not so helpful when you need
             * to extract the value. So will need to parse string response to
             * get geocode values <SOAP-ENV:Envelope> <SOAP-ENV:Body>
             * <ns1:LatLonListZipCodeResponse> <listLatLonOut
             * xsi:type="xsd:string"> <?xml version='1.0' ?> <dwml
             * version='1.0' > <latLonList> 35.1056,-90.007
             * </latLonList> </dwml> </listLatLonOut>
             * </ns1:LatLonListZipCodeResponse> </SOAP-ENV:Body>
             * </SOAP-ENV:Envelope>
             */
            /*String geocodeBuffer = geocodeMsg.getSOAPBody().
                    getElementsByTagName("listLatLonOut")
                    .item(0).getFirstChild().getNodeValue();

            // .getNodeValue() unescapes HTML string
            String geocodeVals = geocodeBuffer.substring(
                    geocodeBuffer.indexOf("<latLonList>") + 12,
                    geocodeBuffer.indexOf("</latLonList>"));
            System.out.println("Geocode Vals for zip code " + zipCode
                    + " are: " + geocodeVals);

            /*
             * NDFDgenLatLonList operation: gets weather data for a given
             * latitude, longitude pair
             *
             * Format of the Message: <S:Envelope
             * xmlns:S="http://schemas.xmlsoap.org/soap/envelope/"
             * xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance"
             * xmlns:schNS="{schemaNS above}"> <S:Body> <NDFDgenLatLonList
             * S:encodingStyle="{encoding style above}"> <schNS:listLatLon
             * xsi:type="schNS:listLatLonType"> 38.99,-77.02 </schNS:listLatLon>
             * <schNS:product xsi:type="schNS:productType"> glance
             * </schNS:product> </NDFDgenLatLonList> </S:Body> </S:Envelope>
             */
            /*SOAPFactory soapFactory = SOAPFactory.newInstance();
            SOAPMessage getWeatherMsg = msgFactory.createMessage();
            SOAPHeader header = getWeatherMsg.getSOAPHeader();
            header.detachNode();  // no header needed
            SOAPBody body = getWeatherMsg.getSOAPBody();
            Name functionCall = soapFactory.createName(
                    "NDFDgenLatLonList", "schNS",
                    nsSchema);
            SOAPBodyElement fcElement = body.addBodyElement(functionCall);
            Name attname = soapFactory.createName("encodingStyle", "S",
                    soapSchema);
            fcElement.addAttribute(attname, soapSchema);
            SOAPElement geocodeElement = fcElement.addChildElement("listLatLon");
            geocodeElement.addTextNode(geocodeVals);
            SOAPElement product = fcElement.addChildElement("product");
            product.addTextNode("glance");

            // make web service call using this SOAPMessage
            Dispatch<SOAPMessage> smDispatch = null;
            smDispatch = service.createDispatch(portName,
                    SOAPMessage.class, Service.Mode.MESSAGE);
            SOAPMessage weatherMsg = smDispatch.invoke(getWeatherMsg);
            //weatherMsg.writeTo(System.out); // debugging only



            // Metro needs normalize() command because it breaks
            // up child dwml element into numerous text nodes.
            weatherMsg.getSOAPBody().getElementsByTagName("dwmlOut")
                    .item(0).normalize();

            // First child of dwmlOut is the dwml element that we need.
            // It is the root node of the weather data that we will
            // be using to generate the report.
            String weatherResponse = weatherMsg.getSOAPBody().
                    getElementsByTagName("dwmlOut")
                    .item(0).getFirstChild().getNodeValue();
            obj = XML.toJSONObject(weatherResponse);

            System.out.println(obj.toString());
            //System.out.println("WR: " + weatherResponse);
        } catch (SOAPFaultException e) {
            System.out.println("SOAPFaultException: " + e.getFault().getFaultString());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Beginning of writing String to File

        File file = new File("c:/newfile.txt");
        String content = obj.toString();

        try (FileOutputStream fop = new FileOutputStream(file)) {

            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Beginning of sending File to Server

        /*FTPClient con = null;

        try
        {
            con = new FTPClient();
            con.connect("ftp.memedoppler.com");

            if (con.login("WeatherData@memedoppler.com", "abeV!godalives"))
            {
                con.enterLocalPassiveMode(); // important!
                con.setFileType(FTP.BINARY_FILE_TYPE);
                String data = "c:/newfile.txt";

                FileInputStream in = new FileInputStream(data);
                //boolean result =
                con.storeFile("/home/memeicou/public_html/WeatherData/newfile.txt", in);
                in.close();
                //if (result) Log.v("upload result", "succeeded");
                con.logout();
                con.disconnect();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        } */

        // Second attempt at FTP

       /* LEAVE COMMENTED try {
            FTPFunctions ftpobj = new FTPFunctions("server119.web-hosting.com", 21, "WeatherData@memedoppler.com", "abeV!godalives");
            ftpobj.uploadFTPFile("C:\\newfile1.txt", "gggggggg.txt", "/");
            ftpobj.downloadFTPFile("gggggggg.txt", "/newfile2.txt");
            System.out.println("FTP File downloaded successfully");
            boolean result = ftpobj.listFTPFiles("/", "gggggggg.txt");
            System.out.println(result);
            ftpobj.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    public class FTPFunctions {

        // Creating FTP Client instance
        FTPClient ftp = null;

        // Constructor to connect to the FTP Server
        public FTPFunctions(String host, int port, String username, String password) throws Exception {

            ftp = new FTPClient();
            ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
            int reply;
            ftp.connect(host, port);
            System.out.println("FTP URL is:" + ftp.getDefaultPort());
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                throw new Exception("Exception in connecting to FTP Server");
            }
            ftp.login(username, password);
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            ftp.enterLocalPassiveMode();
        }

        // Method to upload the File on the FTP Server
        public void uploadFTPFile(String localFileFullName, String fileName, String hostDir)
                throws Exception {
            try {
                InputStream input = new FileInputStream(new File(localFileFullName));

                this.ftp.storeFile(hostDir + fileName, input);
            } catch (Exception e) {

            }
        }

        // Download the FTP File from the FTP Server
        public void downloadFTPFile(String source, String destination) {
            try (FileOutputStream fos = new FileOutputStream(destination)) {
                this.ftp.retrieveFile(source, fos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // list the files in a specified directory on the FTP
        public boolean listFTPFiles(String directory, String fileName) throws IOException {
            // lists files and directories in the current working directory
            boolean verificationFilename = false;
            FTPFile[] files = ftp.listFiles(directory);
            for (FTPFile file : files) {
                String details = file.getName();
                System.out.println(details);
                if (details.equals(fileName)) {
                    System.out.println("Correct Filename");
                    verificationFilename = details.equals(fileName);
                    assertTrue("Verification Failed: The filename is not updated at the CDN end.", details.equals(fileName));
                }
            }

            return verificationFilename;
        }

        // Disconnect the connection to FTP
        public void disconnect() {
            if (this.ftp.isConnected()) {
                try {
                    this.ftp.logout();
                    this.ftp.disconnect();
                } catch (IOException f) {
                    // do nothing as file is already saved to server
                }
            }
        }
    }//*/
}
