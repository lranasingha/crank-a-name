package can.server.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

@RestController
@RequestMapping("/can")
public class CrankNameRequestController {
    @RequestMapping(value = "/heartbeat", method = RequestMethod.HEAD)
    public ResponseEntity<String> heartBeat() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/cranksaname", produces = "text/plain", method = RequestMethod.GET)
    public ResponseEntity<String> cranksAName() {
        return new ResponseEntity<>(aNewName(), HttpStatus.OK);
    }

    private String aNewName() {
        Random random = new Random();
        return IntStream.
                range(0, random.nextInt(26))
                .limit(10)
                .mapToObj(i -> Character.toString((char) (Character.forDigit(i, 10) + 65)))
                .collect(joining());
    }
}
