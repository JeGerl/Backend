# InspectionController Api

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addStepToInspection**](InspectionControllerApi.md#addStepToInspection) | **POST** /api/inspections/{id}/steps |  |
| [**createInspection**](InspectionControllerApi.md#createInspection) | **POST** /api/inspections |  |
| [**getAllInspections**](InspectionControllerApi.md#getAllInspections) | **GET** /api/inspections |  |
| [**removeStepFromInspection**](InspectionControllerApi.md#removeStepFromInspection) | **DELETE** /api/inspections/{id}/steps/{stepId} |  |
| [**updateStepInInspection**](InspectionControllerApi.md#updateStepInInspection) | **PUT** /api/inspections/{id}/steps/{stepId} |  |


<a name="addStepToInspection"></a>
# **addStepToInspection**
> Inspection addStepToInspection(id, InspectionStep)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**|  | [default to null] |
| **InspectionStep** | [**InspectionStep**](../Models/InspectionStep.md)|  | |

### Return type

[**Inspection**](../Models/Inspection.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

<a name="createInspection"></a>
# **createInspection**
> Inspection createInspection(Inspection)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **Inspection** | [**Inspection**](../Models/Inspection.md)|  | |

### Return type

[**Inspection**](../Models/Inspection.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

<a name="getAllInspections"></a>
# **getAllInspections**
> List getAllInspections()



### Parameters
This endpoint does not need any parameter.

### Return type

[**List**](../Models/Inspection.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="removeStepFromInspection"></a>
# **removeStepFromInspection**
> Inspection removeStepFromInspection(id, stepId)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**|  | [default to null] |
| **stepId** | **Long**|  | [default to null] |

### Return type

[**Inspection**](../Models/Inspection.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="updateStepInInspection"></a>
# **updateStepInInspection**
> Inspection updateStepInInspection(id, stepId, InspectionStep)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**|  | [default to null] |
| **stepId** | **Long**|  | [default to null] |
| **InspectionStep** | [**InspectionStep**](../Models/InspectionStep.md)|  | |

### Return type

[**Inspection**](../Models/Inspection.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

# Checklist Api


| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addStepToChecklist**](ChecklistControllerApi.md#addStepToChecklist) | **POST** /api/checklists/{id}/steps |  |
| [**createChecklist**](ChecklistControllerApi.md#createChecklist) | **POST** /api/checklists |  |
| [**getAllChecklists**](ChecklistControllerApi.md#getAllChecklists) | **GET** /api/checklists |  |
| [**removeStepFromChecklist**](ChecklistControllerApi.md#removeStepFromChecklist) | **DELETE** /api/checklists/{id}/steps/{stepId} |  |
| [**updateStepInChecklist**](ChecklistControllerApi.md#updateStepInChecklist) | **PUT** /api/checklists/{id}/steps/{stepId} |  |


<a name="addStepToChecklist"></a>
# **addStepToChecklist**
> Checklist addStepToChecklist(id, ChecklistStep)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**|  | [default to null] |
| **ChecklistStep** | [**ChecklistStep**](../Models/ChecklistStep.md)|  | |

### Return type

[**Checklist**](../Models/Checklist.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

<a name="createChecklist"></a>
# **createChecklist**
> Checklist createChecklist(Checklist)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **Checklist** | [**Checklist**](../Models/Checklist.md)|  | |

### Return type

[**Checklist**](../Models/Checklist.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

<a name="getAllChecklists"></a>
# **getAllChecklists**
> List getAllChecklists()



### Parameters
This endpoint does not need any parameter.

### Return type

[**List**](../Models/Checklist.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="removeStepFromChecklist"></a>
# **removeStepFromChecklist**
> Checklist removeStepFromChecklist(id, stepId)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**|  | [default to null] |
| **stepId** | **Long**|  | [default to null] |

### Return type

[**Checklist**](../Models/Checklist.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="updateStepInChecklist"></a>
# **updateStepInChecklist**
> Checklist updateStepInChecklist(id, stepId, ChecklistStep)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**|  | [default to null] |
| **stepId** | **Long**|  | [default to null] |
| **ChecklistStep** | [**ChecklistStep**](../Models/ChecklistStep.md)|  | |

### Return type

[**Checklist**](../Models/Checklist.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*



