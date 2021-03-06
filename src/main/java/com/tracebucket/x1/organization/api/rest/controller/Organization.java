package com.tracebucket.x1.organization.api.rest.controller;

import com.tracebucket.tron.ddd.domain.AggregateId;
import com.tracebucket.tron.ddd.domain.EntityId;
import com.tracebucket.x1.organization.api.domain.impl.jpa.PositionType;
import com.tracebucket.x1.organization.api.rest.resource.*;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sadath on 20-Apr-15.
 */
public interface Organization {
    public ResponseEntity<DefaultOrganizationResource> createOrganization(DefaultOrganizationResource organization);
    public ResponseEntity<DefaultOrganizationResource> getOrganization(HttpServletRequest request, String aggregateId);
    public ResponseEntity<Boolean> deleteOrganization(HttpServletRequest request, String aggregateId);
    public ResponseEntity<Boolean> deleteOrganizationUnit(HttpServletRequest request, String organizationAggregateId, String organizationUnitntityId);
    public ResponseEntity<DefaultOrganizationResource> addBaseCurrency(HttpServletRequest request, DefaultCurrencyResource baseCurrency, String aggregateId);
    public ResponseEntity<DefaultOrganizationResource> addTimezone(HttpServletRequest request, DefaultTimezoneResource timezone, String aggregateId);
    public ResponseEntity<DefaultOrganizationUnitResource> addOrganizationUnit(HttpServletRequest request, String aggregateId, DefaultOrganizationUnitResource organizationUnit);
    public ResponseEntity<DefaultOrganizationResource> addOrganizationUnitBelow(HttpServletRequest request, DefaultOrganizationUnitResource organizationUnit,
                                                        String parentOrganizationUnitEntityId, String aggregateId);
    public ResponseEntity<DefaultOrganizationResource> restructureOrganizationUnit(HttpServletRequest request, DefaultOrganizationUnitRestructureResource restructureResource);
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
    public ResponseEntity<List<DefaultPositionResource>> getPositions(HttpServletRequest request, String aggregateId);
    public ResponseEntity<DefaultPositionResource> addPosition(HttpServletRequest request, DefaultPositionResource position, String aggregateId);
    public ResponseEntity<DefaultOrganizationResource> addPositionBelow(HttpServletRequest request, DefaultPositionResource position, String parentPositionEntityId, String aggregateId);
    public ResponseEntity<DefaultPositionResource> getPosition(HttpServletRequest request, String aggregateId, String entityId);
    public ResponseEntity<DefaultPositionResource> updatePosition(HttpServletRequest request, DefaultPositionResource position, String aggregateId, String entityId);
    public ResponseEntity<DefaultOrganizationResource> restructureOrganizationUnits(HttpServletRequest request, DefaultOrganizationResource organizationResource);
    public ResponseEntity<PositionType[]> getPositionTypes(HttpServletRequest request);
    public ResponseEntity<DefaultOrganizationResource> addPositionToOrganizationUnit(HttpServletRequest request, AggregateId organizationAggregateId, EntityId organizationUnitEntityId, List<String> positions);
    public ResponseEntity<DefaultOrganizationResource> updatePositionsOfOrganizationUnit(HttpServletRequest request, AggregateId organizationAggregateId, EntityId organizationUnitEntityId, List<String> positions);
    public ResponseEntity<DefaultOrganizationResource> removePositionsOfOrganizationUnit(HttpServletRequest request, AggregateId organizationAggregateId, EntityId organizationUnitEntityId, List<String> positions);
    public ResponseEntity<Set<DefaultPositionResource>> getPositionsOfOrganizationUnit(HttpServletRequest request, AggregateId organizationAggregateId, EntityId organizationUnitEntityId);
    public ResponseEntity<DefaultOrganizationUnitPositions> getOrganizationUnitPositions(HttpServletRequest request, String aggregateId);
    public ResponseEntity<DefaultOrganizationUnitPositions> getOrganizationUnitsPositions(HttpServletRequest request, String aggregateId);
    public ResponseEntity<Set<DefaultOrganizationUnitResource>> searchOrganizationUnits(HttpServletRequest request, String organizationAggregateId, String searchTerm);
    public ResponseEntity<Set<DefaultPositionResource>> searchPositions(HttpServletRequest request, String organizationAggregateId, String searchTerm);
    public ResponseEntity<DefaultOrganizationResource> restructureOrganizationUnitsPositions(HttpServletRequest request, String organizationUid, DefaultPositionRestructureResource positionStructure);
    public ResponseEntity<Set<DefaultOrganizationUnitResource>> getOrganizationUnitsUnstructured(HttpServletRequest request, String organizationUid);
    public ResponseEntity<Set<DefaultDepartmentResource>> addDepartmentToOrganization(HttpServletRequest request, String organizationAggregateId, DefaultDepartmentResources departments);
    public ResponseEntity<Set<DefaultDepartmentResource>> updateDepartmentOfOrganization(HttpServletRequest request, String organizationAggregateId, DefaultDepartmentResources departments);
    public ResponseEntity<Set<DefaultDepartmentResource>> getDepartmentsOfOrganization(HttpServletRequest request, String organizationAggregateId);
    public ResponseEntity<DefaultOrganizationResource> addDepartmentToOrganizationUnit(HttpServletRequest request, String organizationAggregateId, String organizationUnitEntityId, HashSet<String> departments);
    public ResponseEntity<DefaultOrganizationResource> updateDepartmentOfOrganizationUnit(HttpServletRequest request, String organizationAggregateId, String organizationUnitEntityId, HashSet<String> departments);
    public ResponseEntity<Set<DefaultDepartmentResource>> getDepartmentsOfOrganizationUnit(HttpServletRequest request, String organizationAggregateId, String organizationUnitEntityId);
    public ResponseEntity<DefaultOrganizationNameByIds> getOrganizationNameDetailsByUIDS(HttpServletRequest request, DefaultOrganizationNameByIds resource);
    public ResponseEntity<List<DefaultPositionResource>> restructurePositionHierarchy(HttpServletRequest request, String organizationUid, List<DefaultPositionResource> positionsHierarchy);
    public ResponseEntity<List<DefaultPositionResource>> restructurePositionHierarchy(HttpServletRequest request, DefaultPositionStructureResource positionStructure);

}