package com.ism.repositories;

import com.ism.entities.Personne;

public interface IPatient<T extends Personne> extends Repository<T> {
    
}
