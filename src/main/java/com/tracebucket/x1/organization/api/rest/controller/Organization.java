package com.tracebucket.x1.organization.api.rest.controller;

import com.tracebucket.tron.ddd.domain.AggregateId;
import com.tracebucket.tron.ddd.domain.EntityId;
import com.tracebucket.x1.organization.api.domain.impl.jpa.DefaultDepartment;
import com.tracebucket.x1.organization.api.domain.impl.jpa.DefaultOrganization;
import com.tracebucket.x1.organization.api.domain.impl.jpa.PositionType;
import com.tracebucket.x1.organization.api.rest.resource.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by sadath on 20-Apr-15.
 */
public interface Organization {
    public ResponseEntity<DefaultOrganizationResource> createOrganization(DefaultOrganizationResource organization);
    public ResponseEntity<DefaultOrganizationResource> getOrganization(HttpServletRequest request, String aggregateId);
    public ResponseEntity<Boolean> deleteOrganization(HttpServletRequest request, String aggregateId);
    public ResponseEntity<DefaultOrganizationResource> addBaseCurrency(HttpServletRequest request, DefaultCurrencyResource baseCurrency, String aggregateId);
    public ResponseEntity<DefaultOrganizationResource> addTimezone(HttpServletRequest request, DefaultTimezoneResource timezone, String aggregateId);
    public ResponseEntity<DefaultOrganizationResource> addOrganizationUnit(HttpServletRequest request, String aggregateId, DefaultOrganizationUnitResource organizationUnit);
    public ResponseEntity<DefaultOrganizationResource> addOrganizationUnitBelow(HttpServletRequest request, DefaultOrganizationUnitResource organizationUnit,
                                                        String parentOrganizationUnitEntityId, String aggregateId);
    public ResponseEntity<DefaultOrganizationResource> addContactPerson(HttpServletRequest request, DefaultPersonResource person, String aggregateId);
    public ResponseEntity<DefaultOrganizationResource> setDefaultContactPerson(HttpServletRequest request, DefaultPersonResource person, String aggregateId);
    public ResponseEntity<DefaultOrganizationResource> addContactNumber(HttpServletRequest request, DefaultPhoneResource phone, String aggregateId);
    public ResponseEntity<DefaultOrganizationResource> setDefaultContactNumber(HttpServletRequest request, DefaultPhoneResource phone, String aggregateId);
    public ResponseEntity<DefaultOrganizationResource> addEmail(HttpServletRequest request, DefaultEmailResource email, String aggregateId);
    public ResponseEntity<DefaultOrganizationResource> setDefaultEmail(HttpServletRequest request, DefaultEmailResource email, String aggregateId);
    public ResponseEntity<DefaultOrganizationResource> setHeadOffice(HttpServletRequest request, DefaultAddressResource address, String aggregateId);
    public ResponseEntity<DefaultOrganizationResource> moveHeadOfficeTo(HttpServletRequest request, DefaultAddressResource address, String aggregateId);
    public ResponseEntity<DefaultAddressResource> getHeadOfficeAddress(HttpServletRequest request, String aggregateId);
    public ResponseEntity<Set<DefaultCurrencyResource>> getBaseCurrencies(HttpServletRequest request, String aggregateId);
    public ResponseEntity<Set<DefaultOrganizationUnitResource>> getOrganizationUnits(HttpServletRequest request, String aggregateId);
    public ResponseEntity<Set<DefaultPhoneResource>> getContactNumbers(HttpServletRequest request, String aggregateId);
    public ResponseEntity<Set<DefaultEmailResource>> getEmails(HttpServletRequest request, String aggregateId);
    public ResponseEntity<Set<DefaultOrganizationResource>> getOrganizations();
    public ResponseEntity<Set<DefaultPositionResource>> getPositions(HttpServletRequest request, String aggregateId);
    public ResponseEntity<DefaultOrganizationResource> addPosition(HttpServletRequest request, DefaultPositionResource position, String aggregateId);
    public ResponseEntity<DefaultPositionResource> getPosition(HttpServletRequest request, String aggregateId, String entityId);
    public ResponseEntity<DefaultOrganizationResource> updatePosition(HttpServletRequest request, DefaultPositionResource position, String aggregateId, String entityId);
    public ResponseEntity<DefaultOrganizationResource> restructureOrganizationUnits(HttpServletRequest request, DefaultOrganizationResource organizationResource);
    public ResponseEntity<PositionType[]> getPositionTypes(HttpServletRequest request);
    public ResponseEntity<DefaultOrganizationResource> addPositionToOrganizationUnit(HttpServletRequest request, AggregateId organizationAggregateId, EntityId organizationUnitEntityId, List<String> positions);
    public ResponseEntity<DefaultOrganizationResource> updatePositionsOfOrganizationUnit(HttpServletRequest request, AggregateId organizationAggregateId, EntityId organizationUnitEntityId, List<String> positions);
    public ResponseEntity<Set<DefaultPositionResource>> getPositionsOfOrganizationUnit(HttpServletRequest request, AggregateId organizationAggregateId, EntityId organizationUnitEntityId);
    public ResponseEntity<DefaultOrganizationUnitPositions> getOrganizationUnitPositions(HttpServletRequest request, String aggregateId);
    public ResponseEntity<DefaultOrganizationUnitPositions> getOrganizationUnitsPositions(HttpServletRequest request, String aggregateId);
    public ResponseEntity<Set<DefaultOrganizationUnitResource>> searchOrganizationUnits(HttpServletRequest request, String organizationAggregateId, String searchTerm);
    public ResponseEntity<Set<DefaultPositionResource>> searchPositions(HttpServletRequest request, String organizationAggregateId, String searchTerm);
    public ResponseEntity<DefaultOrganizationResource> restructureOrganizationUnitsPositions(HttpServletRequest request, String organizationUid, DefaultPositionRestructureResource positionStructure);
    public ResponseEntity<Set<DefaultOrganizationUnitResource>> getOrganizationUnitsUnstructured(HttpServletRequest request, String organizationUid);
    public ResponseEntity<DefaultOrganizationResource> addDepartmentToOrganization(HttpServletRequest request, String organizationAggregateId, Set<DefaultDepartmentResource> departments);
    public ResponseEntity<DefaultOrganizationResource> updateDepartmentOfOrganization(HttpServletRequest request, String organizationAggregateId, Set<DefaultDepartmentResource> departments);
    public ResponseEntity<Set<DefaultDepartmentResource>> getDepartmentsOfOrganization(HttpServletRequest request, String organizationAggregateId);
    public ResponseEntity<DefaultOrganizationResource> addDepartmentToOrganizationUnit(HttpServletRequest request, String organizationAggregateId, String organizationUnitEntityId, Set<String> departments);
    public ResponseEntity<DefaultOrganizationResource> updateDepartmentOfOrganizationUnit(HttpServletRequest request, String organizationAggregateId, String organizationUnitEntityId, Set<String> departments);
    public ResponseEntity<Set<DefaultDepartmentResource>> getDepartmentsOfOrganizationUnit(HttpServletRequest request, String organizationAggregateId, String organizationUnitEntityId);
}