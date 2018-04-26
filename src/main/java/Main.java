import com.example.tutorial.AddressBookProtos.*;
//import org.apache.mesos.;
import org.lele.mesos.Protos.*;

import java.util.List;


public class Main {




    public static void main(String[] args) {
        System.out.println("Hello World!");
        FrameworkID frameworkID  = FrameworkID.getDefaultInstance();

        Value tva = Value.newBuilder().setType(Value.Type.TEXT).setText(Value.Text.newBuilder().setValue("arm")).build();
        Attribute ta = Attribute.newBuilder().setName("cpu-arch").setType(tva.getType()).setText(tva.getText()).build();
        OfferID offerID = OfferID.newBuilder().setValue("lele-123").build();
        FrameworkID frameworkID1 = FrameworkID.newBuilder().setValue("spark").build();
        SlaveID slaveID = SlaveID.newBuilder().setValue("slave1").build();

        ExecutorID executorID  = ExecutorID.newBuilder().setValue("exexutor12").build();

        Offer my_offer = Offer.newBuilder()
                .setId(offerID)
                .setFrameworkId(frameworkID1)
                .setSlaveId(slaveID)
                .setHostname("ubuntu12")
                .addExecutorIds(executorID)
                .addAttributes(ta).build();



        String desc_my_offer = my_offer.toString();

        System.out.println(desc_my_offer);

        List<Attribute> my_offer_attrs = my_offer.getAttributesList();
        for(Attribute attribute:my_offer_attrs){
            System.out.println(attribute.getName());
            System.out.println(attribute.getText());
        }

//        Person john =
//                Person.newBuilder()
//                        .setId(1234)
//                        .setName("John Doe")
//                        .setEmail("jdoe@example.com")
//                        .addPhones(
//                                Person.PhoneNumber.newBuilder()
//                                        .setNumber("555-4321")
//                                        .setType(Person.PhoneType.HOME))
//                        .build();

    }
}
