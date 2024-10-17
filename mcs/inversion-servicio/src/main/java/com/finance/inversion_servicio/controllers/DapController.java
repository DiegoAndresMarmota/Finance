import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.List;

@RestController
@RequestMapping("/api/v1/dap")
@RequiredArgsConstructor
public class DapController {

    private final DapService dapService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DapResponse> getAllDaps() {
        return this.dapResponse.getAllDaps();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void agregarDap(@RequestBody DapRequest dapRequest) {
        return this.DapService.agregarDap(dapRequest);
    }
}