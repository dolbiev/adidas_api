package adidasTest;

import adidasTest.requests.AddNewPet;
import adidasTest.requests.DeletePet;
import adidasTest.requests.GetAvailablePets;
import adidasTest.requests.UpdatePetStatus;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        GetAvailablePets.class,
        AddNewPet.class,
        UpdatePetStatus.class,
        DeletePet.class
})
public class Main {
}
