package becode.students.cogit.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    private TypeRepository TypeRepository;

    @Autowired
    public TypeService(TypeRepository TypeRepository) {
        this.TypeRepository = TypeRepository;
    }
    public List<Type> findAll() {
        return TypeRepository.findAll();
    }
}
