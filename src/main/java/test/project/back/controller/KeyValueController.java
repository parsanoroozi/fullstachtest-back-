package test.project.back.controller;

import org.springframework.web.bind.annotation.*;
import test.project.back.model.KeyValueModel;
import test.project.back.repository.KeyValueRepository;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class KeyValueController {

    private final KeyValueRepository repository;

    KeyValueController(KeyValueRepository repository){
        this.repository = repository;
    }

    @GetMapping("/getAll")
    List<KeyValueModel> getKeyValues(){
        System.out.println("fetching all the values...");
        return repository.findAll();
    }

    @GetMapping("/getItem/{id}")
    KeyValueModel getKeyValue(@PathVariable Long id) throws Exception {
        return repository.findById(id).orElseThrow(()-> new Exception("id"));
    }

    @PostMapping("/addItem")
    KeyValueModel addKeyValue(@RequestBody KeyValueModel model){
        System.out.println("adding new model: " + model);
        return repository.save(model);
    }

    @PutMapping("/updateItem/{id}")
    KeyValueModel update(@RequestBody KeyValueModel model, @PathVariable Long id){
        return repository.findById(id).map(item -> {
            item.setKey(model.getKey());
            item.setValue(model.getValue());
            System.out.println("updating model("+id+") to: " + model);
            return repository.save(item);
        }).orElseGet(()->{
                model.setId(id);
                return repository.save(model);
        });
    }

    @DeleteMapping("/deleteItem/{id}")
    void delete(@PathVariable Long id){
        System.out.println("deleting model("+id+")");
        repository.deleteById(id);
    }


}
